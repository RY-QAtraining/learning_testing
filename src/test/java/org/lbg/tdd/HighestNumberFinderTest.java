package org.lbg.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighestNumberFinderTest {
    @Test
    public void find_highest_in_array_of_one_expect_single_item(){
        //arrange
        int input[] = {10};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedRes = 10;

        //action
        int actualRes = cut.fgitindHighestNumber(input);

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
    public void find_highest_in_array_of_two_ascending_expect_first_element(){
        //arrange
        int input[] = {7,13};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedRes = 13;
        //action
        int actualRes = cut.findHighestNumber(input);
        //assert
        assertEquals(expectedRes,actualRes);
    }


}
