package com.javamultithreading;

public class ExtendingThreadImplementation {

    public static void main(String[] args) {
        NewThread thread1 = new NewThread();

        thread1.start();

        try {
            for (int num = 0; num < 5; num++) {
                System.out.println("Main Thread: " + num);
                Thread.sleep(1000);
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("Main Thread Exiting");
    }

}


class NewThread extends Thread {
    NewThread() {
        super("DemoThread");
        System.out.println("Child thread: " + this);
    }
     @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("Child Thread Exiting");
    }
}
