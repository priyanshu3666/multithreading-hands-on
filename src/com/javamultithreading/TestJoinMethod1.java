package com.javamultithreading;

class TestJoinMethod1 extends Thread{
    @Override
    public void run(){
        for(int i=1;i<=5;i++){
            try{
                Thread.sleep(500);
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
            System.out.println(i);
        }
    }
    public static void main(String[] args){
        TestJoinMethod1 thread1 =new TestJoinMethod1();
        TestJoinMethod1 thread2 =new TestJoinMethod1();
        TestJoinMethod1 thread3 =new TestJoinMethod1();
        thread1.start();
        try{
            thread1.join();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }

        thread2.start();
        thread3.start();
    }
}

