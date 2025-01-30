package MultiThreading;

public class SimpleThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running..");
    }

    public static void main(String[] args){
        SimpleThread t1= new SimpleThread();

        SimpleThread t2= new SimpleThread();
        t1.start();
        t2.start();
    }

}
