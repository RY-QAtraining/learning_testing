package org.lbg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SessionTest
{
    @Test
    public void how_mocks_work (){
        // arrange
        ArrayList<String> names = mock(ArrayList.class);
        int expectedResult = 3;
        when(names.size()).thenReturn(3);
        names.add("myname");
        // act
        int actualResult = names.size();

        // assert
        assertEquals(expectedResult,actualResult);
        verify(names,times(1)).size();
        verify(names,times(1)).add(any());
    }

    interface IRegister{
        String getDelegate(int idx);
        int getNumberRegistered();

    }

    class Register implements IRegister
    {
        private ArrayList<String>delegates = new ArrayList<>(); // simulates a DB table
        public Register()
        {
            delegates.add("person1");
            delegates.add("person2");
            delegates.add("person3");
            delegates.add("person4");
            delegates.add("person5");
        }

        public String getDelegate(int idx)
        {
            return delegates.get(idx-1);
        }

        public int getNumberRegistered()
        {
            return delegates.size();
        }
    }

    class Course
    {
        private IRegister reg ;

        public Course(IRegister register){
            reg = register;
        }
        public String getLastPersonRegistered(){
            String result = reg.getDelegate(reg.getNumberRegistered());

            return result;
        }
    }
    @Test
    public void verify_lastName_returned_is_lastName_in_register(){
        //arrange
        IRegister reg = mock(IRegister.class) ;
        Course cut = new Course(reg);
        String expectedResult = "person5";
        when(reg.getDelegate(anyInt())).thenReturn("person5");
        //act
        String actualResult = cut.getLastPersonRegistered();
        //assert
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void verify_if_basket_has_correct_items()
    {
        // arrange
        Basket basket = new Basket();
        Item item1 = new Item("Bananas", 6, 0.19); // 1.14
        Item item2 = new Item("Avocado", 3, 0.89); // 2.67
        Item item3 = new Item("Spinach", 1, 1.27); // 1.27
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedResult = "";
        try
        {
            expectedResult = objectMapper.writeValueAsString(basket);
        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        IDataStore dataStore = mock(IDataStore.class);
        Session cut = new Session(dataStore);
        when(dataStore.getItemsInDB()).thenReturn(basket);

        // act
        String actualResult = cut.getItems();

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void verify_if_basket_has_total_price()
    {
        // arrange
        Basket basket = mock(Basket.class);
        Item item1 = new Item("Bananas", 6, 0.19); // 1.14
        Item item2 = new Item("Avocado", 3, 0.89); // 2.67
        Item item3 = new Item("Spinach", 1, 1.27); // 1.27
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedResult = "";
        try
        {
            expectedResult = objectMapper.writeValueAsString(5.08);
        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        when(basket.getTotal()).thenReturn(5.08);
        IDataStore dataStore = mock(IDataStore.class);
        Session cut = new Session(dataStore);
        when(dataStore.getItemsInDB()).thenReturn(basket);

        // act
        String actualResult = cut.getTotalPrice();

        // assert
        assertEquals(expectedResult, actualResult);
        verify(basket, times(1)).getTotal();
        verify(dataStore,times(1)).getItemsInDB();
    }

    @Test
    public void verify_basket_last_item()
    {
        // arrange
        Basket basket = mock(Basket.class);
        Item item1 = new Item("Bananas", 6, 0.19); // 1.14
        Item item2 = new Item("Avocado", 3, 0.89); // 2.67
        Item item3 = new Item("Spinach", 1, 1.27); // 1.27
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedResult = "";
        try
        {
            expectedResult = objectMapper.writeValueAsString(item3);
        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        when(basket.getLastItem()).thenReturn(item3);
        IDataStore dataStore = mock(IDataStore.class);
        when(dataStore.getItemsInDB()).thenReturn(basket);

        Session cut = new Session(dataStore);

        // act
        String actualResult = cut.getTheLastItemSold();

        // assert
        assertEquals(expectedResult, actualResult);
        verify(basket, times(1)).getLastItem();
        verify(dataStore,times(1)).getItemsInDB();
    }

}