package com.example.demo.myJdk8Demo;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFind {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        Optional<Integer> optional1 = stream.filter(i -> i % 2 == 0).findAny();
        optional1.ifPresent(System.out::println);
//        Optional<Integer> optional2 = stream.filter(i -> i % 2 == 0).findFirst();

    }
}
