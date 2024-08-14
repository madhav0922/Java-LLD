package AdvancedJava.Concurrency.ExecutorsAndCallables.MultiThreadedGenericMergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreadedGenericMergeSort implements Callable<List<? extends Number>> {
    List<? extends Number> list;
    ExecutorService executorService;
    public MultiThreadedGenericMergeSort(List<? extends Number> list, ExecutorService executorService) {
        this.list = list;
        this.executorService = executorService;
    }

    private List<? extends Number> merge(List<? extends Number> left, List<? extends Number> right) {
        List<Number> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        while(i < left.size() && j < right.size()) {
            if(Compare.compare(left.get(i), right.get(j)) == 1) {
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

    private List<? extends Number> mergeSort() throws ExecutionException, InterruptedException {
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

        List<Number> left = new ArrayList<>();
        List<Number> right = new ArrayList<>();

        for(int i = 0 ; i < mid ; i++) {
            left.add(list.get(i));
        }

        for(int i = mid ; i < high ; i++) {
            right.add(list.get(i));
        }

        Future<List<? extends Number>> leftSorted = executorService.submit(new MultiThreadedGenericMergeSort(left, executorService));
        Future<List<? extends Number>> rightSorted = executorService.submit(new MultiThreadedGenericMergeSort(right, executorService));

        List<? extends Number> leftList = leftSorted.get();
        List<? extends Number> rightList = rightSorted.get();

        return merge(leftList, rightList);
    }

    @Override
    public List<? extends Number> call() throws Exception {
        return mergeSort();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> listToSort = Arrays.asList(10,9,8,7,6,5,4,3,2,1);
        ExecutorService executorService = Executors.newCachedThreadPool();

        MultiThreadedGenericMergeSort MultiThreadedGenericMergeSort = new MultiThreadedGenericMergeSort(listToSort, executorService);
        Future<List<? extends Number>> sortedList = executorService.submit(MultiThreadedGenericMergeSort);

        List<? extends Number> list = sortedList.get();

        System.out.println(list);



    }
}
