package com.javamultithreading;

class  Demo1{
    synchronized  void  foo(Demo2 demo2Obj)
    {
        String  name = Thread.currentThread().getName();
        System.out.println(name + " entered Demo1.foo");
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException exception)
        {
            System.out.println("Demo1 Interrupted");
        }
        System.out.println( name +" trying to call  Demo2.last()");
        demo2Obj.last();
    }

    synchronized  void last()
    {
        System.out.println("Inside Demo1.last");
    }
}


class  Demo2{
    synchronized  void  bar(Demo1 demo1Obj)
    {
        String  name = Thread.currentThread().getName();
        System.out.println(name + " entered Demo2.bar");
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException exception)
        {
            System.out.println("Demo2 Interrupted");
        }
        System.out.println( name +" trying to call  Demo1.last()");
        demo1Obj.last();
    }

    synchronized  void last()
    {
        System.out.println("Inside Demo2.last");
    }
}


public class DeadLockExample implements  Runnable{
    Demo1 demo1Obj =  new Demo1();
    Demo2 demo2Obj =  new Demo2();
    Thread thread;

    DeadLockExample()
    {
        Thread.currentThread().setName("Main Thread");
        thread = new Thread(this,"Racing Thread ");
    }

    void deadLockStart()
    {
        thread.start();
        demo1Obj.foo(demo2Obj); // get lock on demo1Obj  in this thread
        System.out.println("Back in Main Thread");
    }

    @Override
    public void run() {
        demo2Obj.bar(demo1Obj);   // get lock on demo2Obj in this thread
        System.out.println("Back in other Thread ");
    }

    public static void main(String[] args) {
        DeadLockExample deadLockExample  = new DeadLockExample();
        deadLockExample.deadLockStart();
    }
}
