package com.javamultithreading;

public class ImplementingRunnableInterface implements Runnable {

    Thread thread;

    ImplementingRunnableInterface(){
        thread = new Thread(this, "My thread");
        System.out.println("Child Thread: "+ thread);
    }
    public void run(){
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("child Thread: "+i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting Child Thread");
    }
}
class ThreadDemo{
    public static void main(String[] args) {
        ImplementingRunnableInterface nt = new ImplementingRunnableInterface();
        nt.thread.start();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Main Thread: "+i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting main thread.");

    }
}