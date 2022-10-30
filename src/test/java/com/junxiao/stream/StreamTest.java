package com.junxiao.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {

    List<Employee> empList = null;

    @Before
    public void init()  {
        Employee emp1 = new Employee(1, "Jack");
        Employee emp2 = new Employee(2, "Mary");
        Employee emp3 = new Employee(3, "Rose");
        empList = Arrays.asList(emp1, emp2, emp3);
    }

    @Test
    public void mathOpTest() {

        //1. Math Operation
        int[] numbers = {4, 6, 13, 90, 16, 2, 0};
        //Min -> OptionalInt
        IntStream.of(numbers).min().ifPresent(System.out::println);
        //Max -> OptionalInt
        System.out.println(Arrays.stream(numbers).max().getAsInt());
        //Average ->OptionalDouble
        Arrays.stream(numbers).average().getAsDouble();
        //Count -> long
        IntStream.of(numbers).count();
        //Sum -> int
        IntStream.of(numbers).sum();

        //2.IntSummaryStatistics
        IntSummaryStatistics statistics = IntStream.of(numbers).summaryStatistics();
        statistics.getMin();
        statistics.getMax();
        statistics.getAverage();
        statistics.getCount();
        statistics.getSum();//return long

    }


    @Test
    public void streamProcessTest() {
        int[] numbers = {4, 6, 13, 90, 16, 2, 0};
        //3. Stream Operations  (create stream -> process stream -> consume stream)
        //get the 3 smallest distinct number
        IntStream.of(numbers)  //create stream
                .distinct()
                .sorted()
                .limit(3)
                .forEach(System.out::println); //consume stream

        //4. create stream
        IntStream.of(numbers);
        IntStream.range(1, 101);
        IntStream.rangeClosed(1, 100);
        IntStream.generate(() -> (int)(Math.random() * 100)).limit(10).forEach(System.out::println);

        IntStream intStream = IntStream.of(numbers);

        //5. process stream
        intStream.distinct();                   //distinct
        intStream.sorted();                     //sort
        intStream.limit(3);             //get first 3
        intStream.skip(3);                   //skip first 3
        intStream.filter(num -> num % 2 == 0);  //only even number
        intStream.map(num -> num *2);           //double each value
        intStream.boxed();                      //convert Int to Integer
        intStream.mapToObj(i -> new Employee(i, "Emp"+i)); //convert to Object

        //6. consume stream
        intStream.average();
        intStream.min();
        intStream.max();
        intStream.sum();
        intStream.count();
        intStream.forEach(System.out::println);
        intStream.toArray();
        intStream.boxed().collect(Collectors.toList()); //collect into List of Integer
        intStream.anyMatch(num -> num % 2 == 1);        //is any odd number?
        intStream.allMatch(num -> num % 2 == 1);        //is all odd number?

    }

    @Test
    public void streamCollectTest() {
        //7. Collectors





    }
}
