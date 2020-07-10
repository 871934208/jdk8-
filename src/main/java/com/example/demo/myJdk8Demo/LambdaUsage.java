package com.example.demo.myJdk8Demo;

public class LambdaUsage {

    @FunctionalInterface
    public interface Adder{
        int add(int a,int b);
    }

    public interface SmartAdder extends Adder{

        int add(long a,long b);
    }
}
