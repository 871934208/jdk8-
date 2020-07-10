package com.example.demo.myThreadDemo;

public class Test {

    private long count = 0;
    private void add10k(){
        int index = 0;
        while(index++ < 100000000){
            count += 1;
        }
    }

    public static long calc(){
        final Test test = new Test();

        // 创建两个线程，执行add()操作
        Thread thread1 = new Thread(test::add10k);
        Thread thread2 = new Thread(test::add10k);

        // 启动两个线程
        thread1.start();
        thread2.start();

        // 等待两个线程执行结束
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return test.count;
    }

    public static void main(String[] args) {
        System.out.println(calc());
    }
}
