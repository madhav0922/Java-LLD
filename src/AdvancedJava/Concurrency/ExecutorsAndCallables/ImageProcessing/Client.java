package AdvancedJava.Concurrency.ExecutorsAndCallables.ImageProcessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        List<List<Integer>> image = new ArrayList<>();

        for(int i = 0; i < 4 ; i++) {
            image.add(Arrays.asList(1,1,1,1));
        }


        System.out.println(image);

        RepaintTask quadrantOne = new RepaintTask(image, 0, image.size() / 2, 0, image.size() / 2);
        RepaintTask quadrantTwo = new RepaintTask(image, 0, image.size() / 2, image.size() / 2, image.size());
        RepaintTask quadrantThree = new RepaintTask(image, image.size() / 2, image.size(), 0, image.size() / 2);
        RepaintTask quadrantFour = new RepaintTask(image, image.size() / 2, image.size(), image.size() / 2, image.size());

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(quadrantOne);
        executorService.submit(quadrantTwo);
        executorService.submit(quadrantThree);
        executorService.submit(quadrantFour);

        executorService.shutdown();

        while(!executorService.isTerminated()) {
            // wait for all tasks to complete and then print the list, else we will have inconsistent values.
        }

        System.out.println(image);
    }
}
