package org.lbg.bankAccApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    private Item item1;
    private Item item2;
    private Item item3;

    @BeforeEach
    public void creteItemsForBasket(){
        item1 = new Item("Bananas",6,0.19);
        item2 = new Item("Avocado",3,0.89);
        item3 = new Item("Spinach",1,1.27);
    }

    @Test
    void verify_total_cost_in_basket() {
        //arrange
        Basket cut = new Basket();
        cut.addItem(item1);
        cut.addItem(item2);
        cut.addItem(item3);
        double expectedResult = 5.08;

        //act
        double actualResult = cut.getTotal();

        //assert
        assertEquals(expectedResult,actualResult,2);
    }

    @Test
    void verify_copy_basket_works()
    {
        //arrange
        Basket source = new Basket();
        source.addItem(item1);
        source.addItem(item2);
        source.addItem(item3);
        double expectedResult = 5.08;
        Basket cut = new Basket(source);
        //act
        double actualResult = cut.getTotal();

        //assert
        assertEquals(expectedResult,actualResult,2);
    }
}