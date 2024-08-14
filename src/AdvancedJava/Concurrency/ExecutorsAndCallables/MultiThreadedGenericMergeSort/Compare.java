package AdvancedJava.Concurrency.ExecutorsAndCallables.MultiThreadedGenericMergeSort;

public class Compare {

    public static <T extends Number> int compare(T o1, T o2) {
        return Double.compare(o1.doubleValue(), o2.doubleValue());
    }
}
