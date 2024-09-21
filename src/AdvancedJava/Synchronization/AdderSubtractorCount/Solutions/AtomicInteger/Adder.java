package AdvancedJava.Synchronization.AdderSubtractorCount.Solutions.AtomicInteger;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    AtomicCount count;

    public Adder(AtomicCount count) {
        this.count = count;
    }

    @Override
    public Void call() {
        for(int i = 0 ; i < 50000; i++) {
            count.value.addAndGet(1);
            // System.out.println("Value " + count.value.get());
        }
        return null;
    }
}
