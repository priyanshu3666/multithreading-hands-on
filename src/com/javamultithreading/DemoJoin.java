package com.javamultithreading;

public class DemoJoin {
    public static void main(String[] args) {
        NewThread1 newThread1 = new NewThread1("One");
        NewThread1 newThread2 = new NewThread1("Two");
        NewThread1 newThread3 = new NewThread1("Three");

        //start the thread
        newThread1.thread.start();
        newThread2.thread.start();
        newThread3.thread.start();

        System.out.println("Thread one is alive :" +newThread1.thread.isAlive());
        System.out.println("Thread two is alive :" +newThread2.thread.isAlive());
        System.out.println("Thread three is alive :" +newThread3.thread.isAlive());

        //wait  for the threads to finish
        try{
            System.out.println("Waiting for the threads to finish");
            newThread1.thread.join();
            newThread2.thread.join();
            newThread3.thread.join();
        }
        catch(InterruptedException exception){
            System.out.println("Main threads interrupted");
        }

        System.out.println("Thread one is alive :" +newThread1.thread.isAlive());
        System.out.println("Thread two is alive :" +newThread2.thread.isAlive());
        System.out.println("Thread three is alive :" +newThread3.thread.isAlive());
        System.out.println("Main thread exiting");
    }
}
