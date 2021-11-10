package com.javamultithreading;

// THis  program is not  synchronised
class CallMe {
    void call(String msg){
        System.out.println(" [ " + msg);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException exception)
        {
            System.out.println("Interrupted");
        }
        System.out.println(" ] ");
    }
}

class  Caller implements  Runnable{
    String msg;
    CallMe target;
    Thread thread;
    public  Caller(CallMe targ, String str ){
        target = targ;
        msg = str;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        target.call(msg);
    }
}

public class Synch {
    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller obj1 = new Caller(target,"Hello");
        Caller obj2 = new Caller(target,"Synchronised");
        Caller obj3 = new Caller(target,"World");

        // starting  the threads
        obj1.thread.start();
        obj2.thread.start();
        obj3.thread.start();

        //wait for the threads  to end
        try {
            obj1.thread.join();
            obj2.thread.join();
            obj3.thread.join();
        } catch (InterruptedException exception){
            System.out.println("Interrupted");
        }
    }
}
