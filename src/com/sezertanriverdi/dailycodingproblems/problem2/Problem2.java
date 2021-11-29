package com.sezertanriverdi.dailycodingproblems.problem2;

import java.util.Arrays;

public class Problem2 {
    /*
     * Good morning! Here's your coding interview problem for today.
     *
     * This problem was asked by Uber.
     *
     * Given an array of integers, return a new array such that each element at index i of
     * the new array is the product of all the numbers in the original array except the one at i.
     *
     * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
     * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
     *
     * Follow-up: what if you can't use division?
     */

    public static void main(String[] args) {
        final int[] arrayOfIntegers = {1, 2, 3, 4, 5};
        final int[] resultArray = new int[arrayOfIntegers.length];

        for (int i = 0; i < arrayOfIntegers.length; i++) {
            final int upperElement = arrayOfIntegers[i];
            int result = 1;
            for (int k = 0; k < arrayOfIntegers.length; k++) {
                final int innerElement = arrayOfIntegers[k];
                if (innerElement == upperElement) {
                    continue;
                }

                result *= innerElement;
            }

            resultArray[i] = result;
        }

        System.out.println(Arrays.toString(resultArray));
    }
}
