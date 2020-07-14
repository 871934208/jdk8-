package com.example.demo.myThreadDemo.chapter2;

public class BankVersion2 {

    private final static int MAX = 50;

    public static void main(String[] args) {
        final TicketWindowRunnable ticketWindowRunnable = new TicketWindowRunnable();
        final Runnable ticketWindow = ()->{
            int index = 1;
            while (index <= MAX)
                System.out.println(Thread.currentThread() + " 的号码是：" + (index++));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(ticketWindowRunnable,"一号窗口");
        Thread thread2 = new Thread(ticketWindowRunnable,"二号窗口");
        Thread thread3 = new Thread(ticketWindowRunnable,"三号窗口");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
