package org.lbg.tdd;

import java.lang.reflect.Array;

public class HighestNumberFinder {

    public int findHighestNumber(int[] input) {
        int highestSoFar = input[0];

        if(input.length >1 && input[1]>highestSoFar)
            highestSoFar = input[1];
        return highestSoFar;

    }
}
