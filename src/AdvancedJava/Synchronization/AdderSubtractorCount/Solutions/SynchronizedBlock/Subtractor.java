package AdvancedJava.Synchronization.AdderSubtractorCount.Solutions.SynchronizedBlock;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {
    final Count count;

    public Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 0 ; i < 10000 ; i++) {
            synchronized (count) {
                count.value--;
            }
        }
        return null;
    }
}
