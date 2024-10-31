package org.lbg.tdd;

import java.lang.reflect.Array;

public class HighestNumberFinder {

    public int findHighestNumber(int[] input) {
        if (input.length == 0)
            throw new ArrayIndexOutOfBoundsException("Array is empty");
        int highestSoFar = input[0];
        for(int num: input) {
            if (num > highestSoFar)
                highestSoFar = num;
        }
        return highestSoFar;

    }
}
