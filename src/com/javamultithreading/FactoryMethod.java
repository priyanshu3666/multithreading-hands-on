package com.javamultithreading;
             // A factory method that creates and start a Thread.

public class FactoryMethod  extends Thread{
    public  static  FactoryMethod createAndStart()
    {
        FactoryMethod threadObj = new FactoryMethod();
        threadObj.start();
        return  threadObj;
    }
    @Override
    public void run() {
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        // one method  to create and starting a thread
        // if you want object reference
        FactoryMethod obj = FactoryMethod.createAndStart();
        // if you don't want object reference
        FactoryMethod.createAndStart();

        // Another method
        FactoryMethod obj2 = new FactoryMethod();
        obj2.start();
    }
}
