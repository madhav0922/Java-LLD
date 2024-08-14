package AdvancedJava.Concurrency.ExecutorsAndCallables.MultiThreadedMergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreadedMergeSort implements Callable<List<Integer>> {
    public List<Integer> list;
    public ExecutorService executorService;
    public MultiThreadedMergeSort(List<Integer> list, ExecutorService executorService) {
        this.list = list;
        this.executorService = executorService;
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        while(i < left.size() && j < right.size()) {
            if(left.get(i) < right.get(j)) {
                mergedList.add(left.get(i));
                i++;
            } else {
                mergedList.add(right.get(j));
                j++;
            }
        }
        while(i < left.size()) {
            mergedList.add(left.get(i));
            i++;
        }
        while(j < right.size()) {
            mergedList.add(right.get(j));
            j++;
        }
        return mergedList;
    }

    private List<Integer> mergeSort() throws ExecutionException, InterruptedException {
        /* **************
         Super important to have the base case.
         SINCE CALL METHOD IS RECURSIVE HERE.
         IT SHOULD KNOW WHEN TO STOP.
        ************** */

        // Base case
        if(list.size() <= 1) {
            return list;
        }

        int low = 0,
                high = list.size(),
                mid = low + (high - low) / 2;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i = 0 ; i < mid ; i++) {
            left.add(list.get(i));
        }
        System.out.println(left);

        for(int i = mid ; i < high ; i++) {
            right.add(list.get(i));
        }
        System.out.println(right);

        MultiThreadedMergeSort leftPart = new MultiThreadedMergeSort(left, executorService);
        MultiThreadedMergeSort rightPart = new MultiThreadedMergeSort(right, executorService);

        Future<List<Integer>> leftSorted = executorService.submit(leftPart);
        Future<List<Integer>> rightSorted = executorService.submit(rightPart);

        List<Integer> leftList = leftSorted.get();
        List<Integer> rightList = rightSorted.get();

        return merge(leftList, rightList);
    }

    @Override
    public List<Integer> call() throws Exception {
        return mergeSort();
    }
}

