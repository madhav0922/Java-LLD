package AdvancedJava.Synchronization.AdderSubtractorCount.Problem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        Count count = new Count(0);

        // Define Task
        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(adder);
        executorService.submit(subtractor);
        // Sometimes it returns some random value rather it should always return 0.
        // This behavior could more clearly be seen if we add some delay in the adder and subtractor.
        // This is the SYNCHRONIZATION PROBLEM.
        // We need to synchronize the code to fix this problem.
        System.out.println(count.value);
    }
}
