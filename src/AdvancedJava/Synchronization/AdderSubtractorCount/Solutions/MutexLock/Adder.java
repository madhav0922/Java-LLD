package AdvancedJava.Synchronization.AdderSubtractorCount.Solutions.MutexLock;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    Count count;

    Adder(Count count) {
        this.count = count;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 0 ; i < 10000000; i++) {
            count.lock.lock();
                count.value++;
                // System.out.println("Thread name ad " + Thread.currentThread().getName());
            count.lock.unlock();
        }
        return null;
    }
}
