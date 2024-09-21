package AdvancedJava.Synchronization.AdderSubtractorCount.Solutions.AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCount {
    AtomicInteger value;

    public AtomicCount(AtomicInteger value) {
        this.value = value;
    }
}
