package AdvancedJava.Synchronization.AdderSubtractorCount.Solutions.SynchronizedBlock;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private final Count count;

    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 0 ; i < 10000 ; i++) {
            synchronized (count) {
                count.value++;
            }
        }
        return null;
    }
}
