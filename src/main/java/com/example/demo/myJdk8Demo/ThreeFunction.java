package com.example.demo.myJdk8Demo;

@FunctionalInterface
public interface ThreeFunction<T,U,K,R> {
    R apply(T t,U u,K k);
}
