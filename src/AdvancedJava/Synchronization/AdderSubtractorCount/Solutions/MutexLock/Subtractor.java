package AdvancedJava.Synchronization.AdderSubtractorCount.Solutions.MutexLock;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {
    Count count;

    Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 0 ; i < 10000000; i++) {
            count.lock.lock();
                count.value--;
                // System.out.println("Thread name sub " + Thread.currentThread().getName());
            count.lock.unlock();
        }
        return null;
    }
}
