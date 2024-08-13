package AdvancedJava.Concurrency.ExecutorsAndCallables.ExecutorDemoThreadPools;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter choice! ");
        int choice = sc.nextInt();

        switch(choice) {
            case 1: fixedThreadExecutorDemo();
                    break;
            case 2: cachedThreadPoolDemo();
                    break;
            case 3: singleThreadExecutorDemo();
                    break;
            case 4: scheduledThreadExecutorDemo();
                    break;
            case 5: workStealingPoolExecutorDemo();
                    break;
        }
    }

    public static void fixedThreadExecutorDemo() {
        // Fixed number of threads to process tasks. Threads are nor destroyed neither new are created.
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10 ; i++) {
            executorService.submit(new Task(i));
        }
        // This line could be printed anywhere, since threads are also working in parallel.
        System.out.println("Observe 5 threads created from same pool");
    }

    public static void cachedThreadPoolDemo() {
        // Optimized thread pool, which auto generates thread and destroys them as per demand.
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0 ; i < 10 ; i++) {
            executorService.submit(new Task(i));
        }
        // This line could be printed anywhere, since threads are also working in parallel.
        System.out.println("Observe n threads created from same pool");
    }

    public static void singleThreadExecutorDemo() {
        // Single / Exactly one thread executor.
        // Useful to execute tasks which depend on each other, or should be executed one after another.
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i = 0 ; i < 10 ; i++) {
            executorService.submit(new Task(i));
        }
        // This line could be printed anywhere, since threads are also working in parallel.
        System.out.println("Observe exactly 1 thread created from same pool");
    }

    public static void scheduledThreadExecutorDemo() {
        // Similar to fixed thread pool with scheduling ability.
        // Useful to schedule re-occurring tasks.
        // Notice here we need this object since, ExecutorService interface does not contain the schedule method.
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for(int i = 1 ; i <= 5 ; i++) {
            executorService.schedule(new Task(i), i, TimeUnit.SECONDS);
            // i will have the same value of 0, mostly since we are working with threads.
        }
        // This line could be printed anywhere, since threads are also working in parallel.
        System.out.println("Observe 5 threads created from same pool with an INITIAL delay of 1 second");
        // Why exactly one second?
        // Because the threads are already done with their work at 1 second itself.
        // The value of i is causing them the initial delay of 1 second each, everytime.

        // if a static value such as this is provided, then all threads will arrive at 10 seconds.
        // And not each after a 10-second delay from the previous one, of course that is not what is specified here anyway.
        // But the for loop is not acting as a blocking method (like in case of callable / future). Hence, it won't
        // wait 5 seconds each time. The control will keep scheduling the calls as it wont stop the for loop.
        for(int i = 1 ; i <= 5 ; i++) {
            executorService.schedule(new Task(i), 5, TimeUnit.SECONDS);
            // i will have the same value of 0, mostly since we are working with threads.
        }

    }

    public static void workStealingPoolExecutorDemo() {
        // Used for parallelization / for heavy tasks, to actually parallelize.
        // Dynamically adapts to number of available PROCESSORS.
        // Each worker thread has its own task queue.
        // Used to decrease CONTENTION on the single queue (traditional thread pool where we have only one queue)
        // in case of short but huge number of tasks. (good to use parallel queues for each worker thread)
        // as the queue locks the queue, dequeues a task and then unlocks the queue.
        ExecutorService executorService = Executors.newWorkStealingPool();
        for(int i = 0 ; i < 100 ; i++) {
            executorService.submit(new Task(i));
        }
        // This line could be printed anywhere, since threads are also working in parallel.
        System.out.println("Observe n threads created from same pool but the number terminates before, indicating multiple queues.");
    }


}
