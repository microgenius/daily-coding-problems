package com.sezertanriverdi.dailycodingproblems.personal;

import java.util.Arrays;

public class SortedArrayPowerOfIndex {
    // [-7, -5, -1, 0, 1, 2, 3, 6]
    // [0, 1, 1, 4, 9, 25, 36, 49]

    // [-7, -5, -1, 0, 1, 2, 3, 6]
    // 1st Step 7^2 - 6^2 -> [49]

    // [-7, -5, -1, 0, 1, 2, 3, 6]
    // 2nd Step 5^2 - 6^2 -> [36, 49]

    // [49, 25, 1, 0, 1, 4, 9, 26]
    //Collections.sort

    public static void main(String[] args) {
        final int[] values = {-7, -5, -1, 0, 1, 2, 3, 6};
        int first = 0;
        int last = values.length - 1;
        final int[] result = new int[values.length];

        for (int i = values.length - 1; i >= 0; i--) {
            final int left = values[first];
            final int right = values[last];

            if (Math.abs(left) >= Math.abs(right)) {
                result[i] = left * left;
                first++;
            } else {
                result[i] = right * right;
                last--;
            }
        }

        System.out.println(Arrays.toString(result));
    }
}