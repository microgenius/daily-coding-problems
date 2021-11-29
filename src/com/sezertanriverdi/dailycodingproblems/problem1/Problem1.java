package com.sezertanriverdi.dailycodingproblems.problem1;

import java.util.HashSet;

public class Problem1 {
    /*
     * Good morning! Here's your coding interview problem for today.
     *
     * This problem was recently asked by Google.
     *
     * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
     *
     * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
     *
     * Bonus: Can you do this in one pass?
     */

    public static void main(String[] args) {
        final int[] candidateArray = {10, 15, 3, 7};
        final int k = 17;
        System.out.println(isCandidateNumberExistsForTarget(candidateArray, k));
    }

    private static boolean isCandidateNumberExistsForTarget(int[] candidateArray, int k) {
        final HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < candidateArray.length; i++) {
            final int candidate = candidateArray[i];
            // k - candidate = 7
            if (set.contains(k - candidate)) {
                return true;
            }

            set.add(candidate);
        }

        return false;
    }
}
