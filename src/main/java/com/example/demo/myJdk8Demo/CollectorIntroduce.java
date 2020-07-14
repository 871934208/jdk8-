package com.example.demo.myJdk8Demo;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CollectorIntroduce {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(
                new Apple("green", 110),
                new Apple("yellow", 130),
                new Apple("green", 120),
                new Apple("yellow", 150),
                new Apple("green", 170)
        );

        List<Apple> greenList = list.stream().filter(a -> a.getColor().equals("green")).collect(toList());
        Optional.ofNullable(greenList).ifPresent(System.out::println);
        Optional.ofNullable(groupNormal(list)).ifPresent(System.out::println);
    }

    private static Map<String, List<Apple>> groupNormal(List<Apple> apples) {
        Map<String, List<Apple>> map = new HashMap<>();
        for (Apple a : apples) {
            List<Apple> list = map.get(a.getColor());
            if (null == list) {
                list = new ArrayList<>();
                map.put(a.getColor(), list);
            }
            list.add(a);
        }
        return map;
    }

    private static Map<String, List<Apple>> groupByFunction(List<Apple> apples) {
        Map<String, List<Apple>> map = new HashMap<>();
        apples.stream().forEach(a -> {
            List<Apple> colorList = Optional.ofNullable(map.get(a.getColor())).orElseGet(() -> {
                List<Apple> list = new ArrayList<>();
                map.put(a.getColor(), list);
                return list;
            });
            colorList.add(a);
        });
        return map;
    }

    private static Map<String, List<Apple>> groupByCollector(List<Apple> apples){
        return apples.stream().collect(Collectors.groupingBy(Apple::getColor));
    }



}
