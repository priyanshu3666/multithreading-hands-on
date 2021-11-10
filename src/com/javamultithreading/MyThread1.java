package com.javamultithreading;
public class MyThread1 extends Thread{
    @Override
    public void run(){
        System.out.println("thread is running...");
    }
    public static void main(String[] args){
        MyThread1 t1=new MyThread1();
        t1.start();
    }
}