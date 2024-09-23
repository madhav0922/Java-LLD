package AdvancedJava.Synchronization.AdderSubtractorCount.Solutions.SynchronizedBlock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Count count = new Count(0);
        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Void> ad = executorService.submit(adder);
        Future<Void> sub = executorService.submit(subtractor);

        ad.get();
        sub.get();

        System.out.println("Value " + count.value);
    }
}
