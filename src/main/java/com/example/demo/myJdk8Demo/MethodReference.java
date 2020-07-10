package com.example.demo.myJdk8Demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {

    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        useConsumer(consumer,"Hello Word");

        useConsumer(s -> System.out.println(s),"Hello Word");
        useConsumer(System.out::println,"Hello Word");

        List<Apple> list = Arrays.asList(new Apple("green",110),new Apple("abc",130),new Apple("red",130));
        System.out.println(list);

        list.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });
        list.sort((a1,a2) -> {
            return a1.getColor().compareTo(a2.getColor());
        });
        list.sort(Comparator.comparing(Apple::getColor));

        list.stream().forEach(apple -> System.out.println(apple));

        int value = Integer.parseInt("123");
        Function<String,Integer> fun = Integer::parseInt;
        int value2 = fun.apply("123");

        Character c = "123".charAt(2);
        BiFunction<String,Integer,Character> fun2 = String::charAt;
        Character c2 = fun2.apply("Hello",2);
        System.out.println(c2);

        String s = "Hello";
        Function<Integer,Character> fun3 = s::charAt;
        Character c3 = fun3.apply(2);

        System.out.println("======================");
        Supplier<String> supplier = String::new;
        String s1 = supplier.get();
        System.out.println(s1);

        ThreeFunction<String,Long,String,ComplexApple> threeFunction = ComplexApple::new;
        ComplexApple complexApple = threeFunction.apply("green",120L,"FuShi");
        System.out.println(complexApple);
    }

    private static <T> void useConsumer(Consumer<T> consumer,T t){
        consumer.accept(t);
        consumer.accept(t);
    }
}
