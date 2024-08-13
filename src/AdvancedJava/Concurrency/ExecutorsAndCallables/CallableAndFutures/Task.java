package AdvancedJava.Concurrency.ExecutorsAndCallables.CallableAndFutures;

import java.util.concurrent.Callable;
public class Task implements Callable<String> {
    @Override
    public String call() {
        return "callable returning after the completion of thread";
    }
}
