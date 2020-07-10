package com.example.demo.myJdk8Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class demoTest {

    private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple a : source){
            if (predicate.test(a)){
                result.add(a);
            }
        }
        return result;
    }

    private static List<Apple> filterByWeight(List<Apple> source, LongPredicate predicate){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple a : source){
            if (predicate.test(a.getWeight())){
                result.add(a);
            }
        }
        return result;
    }
    private static List<Apple> filterByBiWeight(List<Apple> source, BiPredicate<String,Long> predicate){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple a : source){
            if (predicate.test(a.getColor(),a.getWeight())){
                result.add(a);
            }
        }
        return result;
    }

    private static void simpleTestConsumer(List<Apple> source, Consumer<Apple> consumer){
        for(Apple a : source){
            consumer.accept(a);
        }
    }

    private static String testFunction(Apple a,Function<Apple,String> fun){
        return fun.apply(a);
    }



    public static void main(String[] agr){

//        Runnable r1 = () -> System.out.println("Hello word");
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hellow word2");
//            }
//        };
//        process(r1);
//        process(r2);
//        process(() -> System.out.println("Hello word3"));

        List<Apple> list = Arrays.asList(new Apple("green",120),new Apple("red",150));

        List<Apple> greenList = filter(list,(apple) -> apple.getColor().equals("green"));
        System.out.println(greenList);

        List<Apple> result = filterByWeight(list,w -> w > 100);
        System.out.println(result);

        List<Apple> result2 = filterByBiWeight(list,(color,weight) -> color.equals("green") && weight > 100);
        System.out.println(result2);

        simpleTestConsumer(list, apple -> System.out.println(apple));
        simpleTestConsumer(list, System.out::println);

        String result3 = testFunction(new Apple("yellow",130),apple -> apple.toString());
        System.out.println(result3);

        IntFunction<Double> fun = i -> i * 100.0;
        Double result4 = fun.apply(10);
        System.out.println(result4);

        Supplier<String> s = String::new;
        System.out.println(s.get());
    }

    private static void process(Runnable r){
        r.run();
    }
}
