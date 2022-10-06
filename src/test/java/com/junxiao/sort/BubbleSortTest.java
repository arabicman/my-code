package com.junxiao.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSortTest {


    @Test
    public void testBubbleSort() {
        //prepare input
        int[] arr1 = {4,2,5,-2, 98,65};
//        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        int[] arr2 = list.stream().mapToInt(i -> i).toArray();

        //before sort
        System.out.println("before: ");
        Arrays.stream(arr2).forEach(i -> System.out.print(i + ","));
        //sort
        BubbleSort.sort(arr2);
        //after sort
        System.out.println('\n');
        System.out.println("after: ");
        Arrays.stream(arr2).forEach(i -> System.out.print(i + ","));
    }
}