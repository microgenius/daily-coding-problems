package com.sezertanriverdi.dailycodingproblems.problem4;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem4 {
    /**
     * Good morning! Here's your coding interview problem for today.
     *
     * This problem was asked by Stripe.
     *
     * Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
     *
     * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
     *
     * You can modify the input array in-place.
     */
    public static void main(String[] args) {
        int[] input = {3, 4, -1, 1};

        System.out.println(findLowestMissingPositiveNumber(input));
        System.out.println(findLowestMissingPositiveNumber2(input));
    }

    public static int findLowestMissingPositiveNumber(int[] input) {
        int candidate = 1;
        while(candidate <= input.length) {
            boolean found = false;
            for (int i = 0; i < input.length; i++) {
                if (input[i] == candidate) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return candidate;
            }

            candidate++;
        }

        return -1;
    }

    public static int findLowestMissingPositiveNumber2(int[] input) {
        final OptionalInt optResult = IntStream.iterate(1, x -> x + 1)
            .filter(x ->
                Arrays.stream(input)
                    .filter(value -> value > 0)
                    .noneMatch(value -> value == x)
            )
            .findFirst();

        return optResult.orElse(-1);
    }
}
