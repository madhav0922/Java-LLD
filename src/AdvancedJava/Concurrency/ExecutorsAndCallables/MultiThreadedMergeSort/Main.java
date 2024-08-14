package AdvancedJava.Concurrency.ExecutorsAndCallables.MultiThreadedMergeSort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> listToSort = Arrays.asList(10,9,8,7,6,5,4,3,2,1);
        ExecutorService executorService = Executors.newCachedThreadPool();

        MultiThreadedMergeSort multiThreadedMergeSort = new MultiThreadedMergeSort(listToSort, executorService);
        Future<List<Integer>> sortedList = executorService.submit(multiThreadedMergeSort);

        List<Integer> list = sortedList.get();
        executorService.shutdown();

        System.out.println(list);
    }
}
