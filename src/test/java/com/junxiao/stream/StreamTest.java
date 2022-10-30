package com.junxiao.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamTest {

    @Test
    public void test() {

        //1. Math Operation
        int[] numbers = {4, 6, 13, 90, 16, 2, 0};
        //Min -> OptionalInt
        IntStream.of(numbers).min().ifPresent(System.out::println);
        //Max -> OptionalInt
        System.out.println(Arrays.stream(numbers).max().getAsInt());
        //Average ->OptionalDouble
        System.out.println(Arrays.stream(numbers).average().getAsDouble());
        //Count -> long
        System.out.println(IntStream.of(numbers).count());
        //Sum -> int
        System.out.println(IntStream.of(numbers).sum());
    }
}
