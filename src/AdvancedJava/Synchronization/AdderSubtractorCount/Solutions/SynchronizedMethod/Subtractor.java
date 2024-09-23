package AdvancedJava.Synchronization.AdderSubtractorCount.Solutions.SynchronizedMethod;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {
    private final Count count;
    public Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 0 ; i < 10000 ; i++) {
            count.decrement();
        }
        return null;
    }
}
