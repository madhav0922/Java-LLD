package AdvancedJava.Synchronization.AdderSubtractorCount.Solutions.AtomicInteger;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {
    AtomicCount count;

    public Subtractor(AtomicCount count) {
        this.count = count;
    }

    @Override
    public Void call() {
        for(int i = 0 ; i < 50000; i++) {
            count.value.addAndGet(-1);
            // System.out.println("Value " + count.value.get());
        }
        return null;
    }
}
