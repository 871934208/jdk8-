package com.example.demo;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMatch {

    public static void main(String[] args) {

        Stream<Integer> stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8});
        boolean matched = stream.allMatch(i -> i > 0);

        assert matched : "some elements not matched.";

        boolean anyMatch = stream.anyMatch(i -> i > 6);


    }
}
