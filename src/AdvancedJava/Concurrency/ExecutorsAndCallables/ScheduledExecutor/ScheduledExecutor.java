package AdvancedJava.Concurrency.ExecutorsAndCallables.ScheduledExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.scheduleAtFixedRate(() ->
            System.out.println("Hello!")
        , 5,
                5,
                TimeUnit.SECONDS);


    }
}
