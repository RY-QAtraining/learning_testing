package org.lbg.tdd;

import java.lang.reflect.Array;

public class HighestNumberFinder {

    public int findHighestNumber(int[] input) {
        int highestSoFar = input[0];
        for(int num: input) {
            if (num > highestSoFar)
                highestSoFar = num;
        }
        return highestSoFar;

    }
}
