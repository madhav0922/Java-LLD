package AdvancedJava.Synchronization.AdderSubtractorCount.Solutions.AtomicInteger;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Client {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        AtomicInteger value = new AtomicInteger(0);
        AtomicCount count = new AtomicCount(value);

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        // Using thread (fork/join) Fork/Join only and not fork/join framework, i.e. ExecutorService Framework
//        Thread t1 = new Thread(adder);
//        Thread t2 = new Thread(substractor);
//
//        t1.start();
//        t2.start();

        // In case of thread these are important other wise it will give non-zero value.
//        t1.join();
//        t2.join();

        // Using Fork/Join Framework or Executor Service

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Void> ad = executorService.submit(adder);
        Future<Void> sub = executorService.submit(subtractor);

        // its important to call the future, in order to wait for all threads to complete their tasks before retrieving value.
        ad.get();
        sub.get();

        System.out.println("Value " + count.value.get());

    }
}
