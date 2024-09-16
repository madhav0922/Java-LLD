package AdvancedJava.Synchronization.AdderSubtractorCount.Problem;

// This is the Task class
// because we want to increment and decrement the count ultimately
// Count is not a task but a helper to increment (task) and decrement (task)
// or, we can say we want to update the count. (Like producer/consumer problem)
// and producing and consuming both are tasks.
public class Adder implements Runnable {
    private final Count count;

    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 10000 ; i++) {
            count.value++;
        }
    }
}
