package com.example.demo.myThreadDemo.chapter1;

public class TryConcurrency {

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            println(Thread.currentThread().getName());
            readFromDataBase();
        });
//        Thread t2 = new Thread(TryConcurrency::writeDataToFile);
        t1.start();
        t1.run();

//        t2.start();

//        readFromDataBase();
//        writeDataToFile();
    }

    private static void readFromDataBase() {
        //read data from database and handle it.
        try {
            println("Begin read data from db");
            Thread.sleep(1000 * 5L);
            println("Read data done and start handle it.");
                    } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("The data handle finish and successfully.");
    }

    private static void writeDataToFile(){
        //read data from database and handle it.
        try {
            println("Begin write data to file");
            Thread.sleep(1000 * 10L);
            println("Write data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void println(String message){
        System.out.println(message);
    }
}
