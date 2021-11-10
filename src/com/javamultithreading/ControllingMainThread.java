package com.javamultithreading;

public class ControllingMainThread {

    public static void main(String[] args) {
        Thread thread= Thread.currentThread();

        System.out.println("Current Thread :" + thread);

        // change the name of thread
        thread.setName("My Thread ");
        System.out.println("After changing the name :" +thread);

        try{
            for (int num = 0; num < 5; num++) {
                System.out.println(num);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException exception){
            System.out.println("Main Thread interrupted ");
        }
    }
}
