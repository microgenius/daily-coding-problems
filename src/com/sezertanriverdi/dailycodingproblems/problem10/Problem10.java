package com.sezertanriverdi.dailycodingproblems.problem10;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Problem10 {
    /**
     * Good morning! Here's your coding interview problem for today.
     *
     * This problem was asked by Apple.
     *
     * Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
     */

    public static void main(String[] args) {
        long n = 5000;

        final ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(5);
        threadPoolExecutor.schedule(() ->
            {
                System.out.println("Method has executed");
            },
            n,
            TimeUnit.MILLISECONDS
        );
    }
}
