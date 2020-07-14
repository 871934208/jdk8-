package com.example.demo.myThreadDemo.chapter2;

public class TaxCalculatorMain {

    public static void main(String[] args) {
//        TaxCalculator calculator = new TaxCalculator(10000d,2000d){
//            @Override
//            protected double calcTax() {
//                return getSalary() * 0.1 + getBonus() * 0.15;
//            }
//        };
//        double tax = calculator.calculate();

        TaxCalculator calculator = new TaxCalculator(10000d, 2000d,(s, b) -> s * 0.1 + b * 0.15);
//        CalculatorStrategy strategy = new SimpleCalculatorStrategy();
//        calculator.setCalculatorStrategy(strategy);
//        calculator.setCalculatorStrategy((s, b) -> s * 0.1 + b * 0.15);
        System.out.println(calculator.calculate());
    }
}
