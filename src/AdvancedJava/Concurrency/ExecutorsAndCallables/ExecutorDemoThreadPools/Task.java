package AdvancedJava.Concurrency.ExecutorsAndCallables.ExecutorDemoThreadPools;

public class Task implements Runnable {
    int i;
    public Task(int i) {
        this.i = i;
    }
    public void run() {
        System.out.println("Executing task" + this.i + " " + Thread.currentThread().getName());
    }
}
