package com.javamultithreading;

// Suspending and resuming a thread the modern way

class  NewThread3 implements  Runnable{
    String name;
    Thread thread;
    boolean suspendFlag;

    NewThread3(String threadName)
    {
        name = threadName;
        thread = new Thread(this,name);
        System.out.println("New Thread  :" + thread);
        suspendFlag = false;
    }

    // This is the entry point of thread

    @Override
    public void run() {
        try {
            for (int i = 15; i > 0  ; i--) {
                System.out.println(name + " : " + i);
                Thread.sleep(200);
                synchronized ( this) {
                    while (suspendFlag){
                        wait();
                    }
                }
            }
        }
        catch (InterruptedException exception)
        {
            System.out.println(name + " interrupted");
        }
        System.out.println(name + " exiting");
    }

    synchronized  void mySuspend()
    {
        suspendFlag = true;
    }

    synchronized  void myResume()
    {
        suspendFlag = false;
        notifyAll();
    }
}

public class SuspendResume {
    public static void main(String[] args) {
        NewThread3 newThread3Obj1 = new NewThread3("One");
        NewThread3 newThread3Obj2 = new NewThread3("Two");

        newThread3Obj1.thread.start();
        newThread3Obj2.thread.start();

        try {
            Thread.sleep(1000);
            newThread3Obj1.mySuspend();
            System.out.println("Suspending Thread One ");
            Thread.sleep(1000);
            newThread3Obj1.myResume();
            System.out.println("Resuming thread One ");
            newThread3Obj2.mySuspend();
            System.out.println("Suspending Thread Two ");
            Thread.sleep(1000);
            newThread3Obj2.myResume();
            System.out.println("Resuming thread Two ");
        }
        catch (InterruptedException exception)
        {
            System.out.println("Main Thread Interrupted");
        }

        // wait for the threads to finish
        try {
            System.out.println("Waiting for  threads to finish.");
            newThread3Obj1.thread.join();
            newThread3Obj2.thread.join();
        }
        catch (InterruptedException exception)
        {
            System.out.println("Main Thread Interrupted");
        }

        System.out.println("Main Thread exiting ");
    }
}
