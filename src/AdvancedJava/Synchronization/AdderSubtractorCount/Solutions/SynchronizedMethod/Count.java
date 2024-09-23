package AdvancedJava.Synchronization.AdderSubtractorCount.Solutions.SynchronizedMethod;

public class Count {
    protected int value;

    public Count(int value) {
        this.value = value;
    }

    public synchronized void increment() {
        value++;
    }

    public synchronized void decrement() {
        value--;
    }

}
