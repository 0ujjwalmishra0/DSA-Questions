package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{
    int taskId;
    Task(int taskId){
        this.taskId=taskId;
    }

    @Override
    public void run() {
        System.out.println(taskId+ " is running on "+ Thread.currentThread().getName());
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        for (int i = 0; i < 50; i++) {
            Runnable task= new Task(i);
            executorService.submit(task);
        }
        executorService.shutdown();
    }

}



