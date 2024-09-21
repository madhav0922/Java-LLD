package AdvancedJava.Synchronization.AdderSubtractorCount.Solutions.MutexLock;

import java.util.concurrent.locks.Lock;

public class Count {
    int value;

    Lock lock;

    Count(int value, Lock lock) {
        this.value = value;
        this.lock = lock;
    }
}
