package com.javamultithreading;


// Create multiple threads.
class NewThread1 implements Runnable {
    String threadName; // threadName of thread
    Thread thread;

    NewThread1(String threadName) {
        this.threadName =threadName;
        thread =new Thread(this, this.threadName);
        System.out.println("New thread: "+thread);
    }
        // This is the entry point for thread,
    public void run() {
        try{
             for(int i = 5; i > 0; i--){
                 System.out.println(threadName + ": " + i);
                 Thread.sleep(1000);
             }
        }
        catch (InterruptedException exception)
        {
            System.out.println(threadName + "Interrupted");
        }
        System.out.println(threadName + " exiting.");
        }
}
public class MultiThreadingDemo {
    public static void main(String[] args) {
        NewThread1 thread1 = new NewThread1("One");
        NewThread1 thread2 = new NewThread1("Two");
        NewThread1 thread3 = new NewThread1("Three");

        thread1.thread.start();
        thread2.thread.start();
        thread3.thread.start();

        try {
            for (int i=0; i < 5; i++) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread Exiting");
    }
}



