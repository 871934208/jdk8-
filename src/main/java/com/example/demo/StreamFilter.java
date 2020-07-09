package com.example.demo;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamFilter {

    public static void main(String[] args){

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,6,7,1);
        List<Integer> result = list.stream().filter(integer -> integer % 2 == 0).collect(toList());
        System.out.println(result);
        result = list.stream().distinct().limit(5).collect(toList());
        System.out.println(result);
        result = list.stream().skip(5).collect(toList());
        System.out.println(result);
    }
}
