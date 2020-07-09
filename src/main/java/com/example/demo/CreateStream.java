package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CreateStream {

    public static void main(String[] args) {
//        createStreamFromCollection().forEach(System.out::println);
//        createStreamFromFile();
//        createStreamFromIterator().forEach(System.out::println);
        createStreamFromGenerate().forEach(System.out::println);
    }


//    private static Stream<Double> createStreamFromGenerate(){
//        return Stream.generate(Math::random).limit(1);
//    }

    private static Stream<Integer> createStreamFromIterator(){
        Stream<Integer> stream = Stream.iterate(0, n -> n + 2).limit(10);
        return stream;
    }

    private static void createStreamFromFile(){
        Path path = Paths.get("D:\\Documents\\procedure\\demo\\src\\main\\java\\com\\example\\demo\\CreateStream.java");
        try(Stream<String> lines = Files.lines(path)){
            lines.forEach(System.out::println);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    private static Stream<String> createStreamFromArrays(){
        return Arrays.stream(new String[]{"hello", "alex", "wangwenjun", "word", "stream"});
    }

    private static Stream<String> createStreamFromValues(){
        return Stream.of("hello", "alex", "wangwenjun", "word", "stream");
    }

    private static Stream<String> createStreamFromCollection(){
        List<String> list = Arrays.asList("hello", "alex", "wangwenjun", "word", "stream");
        return list.stream();
    }
    private static Stream<obj> createStreamFromGenerate(){
        return Stream.generate(new objSupplier()).limit(10);
    }
    static class objSupplier implements Supplier<obj> {
        private int index = 0;
        private Random random = new Random(System.currentTimeMillis());


        @Override
        public obj get() {
            index = random.nextInt(100);
            return new obj(index, "Name->" + index);
        }
    }
    static class obj{
        private int id;
        private String name;

        public obj(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "obj{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
