package com.javamultithreading;

class CallMe1 {
    void call(String msg){
        System.out.print(" [ " + msg);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException exception)
        {
            System.out.print("Interrupted");
        }
        System.out.println(" ] ");
    }
}

class  Caller1 implements  Runnable {
    String msg;
    final CallMe1 target;
    Thread thread;

    public Caller1(CallMe1 tar, String str) {
        target = tar;
        msg = str;
        thread = new Thread(this);
    }

    // synchronised calls to call
    @Override
    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }
}

public class SyncBlock {
    public static void main(String[] args) {
        CallMe1 target = new CallMe1();
        Caller1 obj1 = new Caller1(target,"Hello");
        Caller1 obj2 = new Caller1(target,"Synchronised");
        Caller1 obj3 = new Caller1(target,"World");

        // Start the threads
        obj1.thread.start();
        obj2.thread.start();
        obj3.thread.start();

        // wait for  the threads to end
        try {
            obj1.thread.join();
            obj2.thread.join();
            obj3.thread.join();
        }
        catch (InterruptedException exception){
            System.out.println("Interrupted");
        }
        

    }
}

