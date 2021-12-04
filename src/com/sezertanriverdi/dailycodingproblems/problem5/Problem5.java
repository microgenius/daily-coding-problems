package com.sezertanriverdi.dailycodingproblems.problem5;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Problem5 {
    /**
     * Good morning! Here's your coding interview problem for today.
     *
     * This problem was asked by Jane Street.
     *
     * cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair.
     * For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
     *
     * Given this implementation of cons:
     *
     * def cons(a, b):
     *     def pair(f):
     *         return f(a, b)
     *     return pair
     * Implement car and cdr.
     */

    public static void main(String[] args) {
        System.out.println(car(cons1(3, 4)));
        System.out.println(cdr(cons1(3, 4)));

        System.out.println(car(cons2(3, 4)));
        System.out.println(cdr(cons2(3, 4)));
    }

    public static <T, U, R> Function<BiFunction<T, U, R>, R> cons2(T a, U b) {
        return f -> f.apply(a, b);
    }

    public static <T, U> T car(Function<BiFunction<T, U, T>, T> cons) {
        return cons.apply((a, b) -> a);
    }

    public static <T, U> U cdr(Function<BiFunction<T, U, U>, U> cons) {
        return cons.apply((a, b) -> b);
    }

    public static class Pair<T> {
        public T first;
        public T last;
    }

    public static  <T> Pair<T> cons1(T first, T last) {
        final Pair<T> pair = new Pair<>();
        pair.first = first;
        pair.last = last;
        return pair;
    }

    public static <T> T car(Pair<T> pair) {
        return pair.first;
    }

    public static <T> T cdr(Pair<T> pair) {
        return pair.last;
    }
}
