package com.javamultithreading;

class TestSleepMethod extends Thread{
    @Override
    public void run(){
        for(int i=1;i<5;i++){
            // the thread will sleep for the 3000 milliseconds
            try{
                Thread.sleep(3000);
            }
            catch(InterruptedException exception)
            {
                exception.printStackTrace();
            }
            System.out.println(i);
        }
    }
    public static void main(String[] args){
        TestSleepMethod t1=new TestSleepMethod();
        TestSleepMethod t2=new TestSleepMethod();

        t1.start();
        t2.start();
    }
}