package com.example.demo.myThreadDemo.chapter2;

public class TicketWindowRunnable implements Runnable {

    private int index = 1;

    private static final int MAX = 50;

    @Override
    public void run() {
        while (index <= MAX)
            System.out.println(Thread.currentThread() + " 的号码是：" + (index++));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
