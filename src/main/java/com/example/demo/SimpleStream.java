package com.example.demo;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class SimpleStream {

    public static void main(String[] agrs){
        List<Dish> menu = Arrays.asList(
                new Dish("pork",false,800,Dish.Type.MEAT),
                new Dish("beef",false,700,Dish.Type.MEAT),
                new Dish("chicken",false,400,Dish.Type.MEAT),
                new Dish("french fries",true,530,Dish.Type.OTHER),
                new Dish("rice",true,350,Dish.Type.OTHER),
                new Dish("season fruit",true,120,Dish.Type.OTHER),
                new Dish("pizza",true,550,Dish.Type.OTHER),
                new Dish("prawns",false,300,Dish.Type.FISH),
                new Dish("salmon",false,450,Dish.Type.FISH)
                );
//        List<String> dishNamesByCollections = getDishNamesByCollections(menu);
//        System.out.println(dishNamesByCollections);
//
//        List<String> dishNamesByStream = getDishNamesByStream(menu);
//        System.out.println(dishNamesByStream);
        Stream<Dish> stream = menu.stream();
        stream.forEach(System.out::println);
        menu.stream().filter(dish -> {
            System.out.println("filtering->" + dish.getName());
            return dish.getCalories() > 300;
        }).map(dish -> {
            System.out.println("map->" + dish.getName());
            return dish.getName();
        }).limit(3).collect(toList());

    }

    private static List<String> getDishNamesByStream(List<Dish> menu){
        return menu.stream().filter(dish -> dish.getCalories() < 400)
                .sorted(comparing(Dish::getCalories)).map(Dish::getName).limit(2).collect(toList());
    }

    private static List<String> getDishNamesByCollections(List<Dish> menu){
        List<Dish> lowCalories = new ArrayList<>();
        for(Dish d: menu){
            if(d.getCalories() < 400){
                lowCalories.add(d);
            }
        }
//        Collections.sort(lowCalories,(d1,d2)->Integer.compare(d1.getCalories(),d2.getCalories()));
        Collections.sort(lowCalories, comparing(Dish::getCalories));
        List<String> dishNamesList = new ArrayList<>();
        for(Dish d:lowCalories){
            dishNamesList.add(d.getName());
        }
        return dishNamesList;
    }


}
