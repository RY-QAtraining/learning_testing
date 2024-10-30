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
        int actualRes = cut.findHighestNumber(input);

        //assert
        assertEquals(expectedRes,actualRes);
    }
}
