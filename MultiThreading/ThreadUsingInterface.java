package MultiThreading;

public class ThreadUsingInterface implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+ "is running..");
    }

    public static void main(String[] args){
        ThreadUsingInterface threadUsingInterface= new ThreadUsingInterface();
        Thread t1= new Thread(threadUsingInterface);
        t1.start();
    }
}
