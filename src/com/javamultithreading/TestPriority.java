package com.javamultithreading;


class TestPriority extends Thread{
    @Override
    public void run(){
        System.out.println("running thread priority is:"+Thread.currentThread().getPriority());
        System.out.println("running thread name is:"+Thread.currentThread().getName());


    }
    public static void main(String[] args){
        TestPriority thread1 =new TestPriority();
        TestPriority thread2 =new TestPriority();
        thread1.setPriority(1);
        thread2.setPriority(8);
        thread1.start();
        thread2.start();

    }
}
