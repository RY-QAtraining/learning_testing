package org.lbg.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HighestNumberFinderTest {
    @Test
    public void find_highest_in_array_of_one_expect_single_item(){
        //arrange
        int input[] = {10};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedRes = 10;

        //action
        int actualRes = cut.findHighestNumber(input);

        //assert
        assertEquals(expectedRes,actualRes);
    }

    @Test
    public void find_highest_in_array_of_two_descending_expect_first_element(){
        //arrange
        int input[] = {13,4};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedRes = 13;
        //action
        int actualRes = cut.findHighestNumber(input);
        //assert
        assertEquals(expectedRes,actualRes);
    }

    @Test
    public void find_highest_in_array_of_two_ascending_expect_last_element(){
        //arrange
        int input[] = {7,13};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedRes = 13;
        //action
        int actualRes = cut.findHighestNumber(input);
        //assert
        assertEquals(expectedRes,actualRes);
    }

    @Test
    public void find_highest_in_array_of_multiple_equals(){
        //arrange
        int input[] = {4,6,13,13};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedRes = 13;
        //action
        int actualRes = cut.findHighestNumber(input);
        //assert
        assertEquals(expectedRes,actualRes);
    }

    @Test
    public void find_highest_in_array_of_multiple_with_negNo(){
        //arrange
        int input[] = {4,5,-8,3,11,-21,6};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedRes = 11;
        //action
        int actualRes = cut.findHighestNumber(input);
        //assert
        assertEquals(expectedRes,actualRes);
    }

    @Test
    public void handle_exception_for_empty_arr(){
        //arrange
        int input[] = {};
        HighestNumberFinder cut = new HighestNumberFinder();
        String expectedMsg = "Array is empty";

        //action
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {cut.findHighestNumber(input);});
        String actualMsg = exception.getMessage();

        //assert
        assertEquals(expectedMsg,actualMsg);

    }



}
