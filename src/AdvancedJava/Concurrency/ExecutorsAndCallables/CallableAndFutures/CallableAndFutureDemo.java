package AdvancedJava.Concurrency.ExecutorsAndCallables.CallableAndFutures;

import java.util.concurrent.*;

public class CallableAndFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create a callable task
        Callable<String> task = new Task();

        // Create executor service.
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Submit/Execute the task and wait for the thread to complete the task.
        // Collect the response after the completion using future.
        // Future waits until the completion of the thread.
        Future<String> future = executorService.submit(task);

        // Get the actual value of String from Future<String>
        // Added the exceptions it can throw in the method declaration
        // throws ExecutionException, InterruptedException
        String message = future.get();

        System.out.println(message);
        // Output (defined in the call() method of Task class)-> callable returning after the completion of thread.
    }
}
