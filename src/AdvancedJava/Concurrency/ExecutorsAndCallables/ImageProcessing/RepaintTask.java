package AdvancedJava.Concurrency.ExecutorsAndCallables.ImageProcessing;

import java.util.List;

public class RepaintTask implements Runnable {
    List<List<Integer>> repaintArray;
    int rowStart, rowEnd;
    int colStart, colEnd;


    public RepaintTask(List<List<Integer>> repaintArray, int rowStart, int rowEnd, int colStart, int colEnd) {
        this.repaintArray = repaintArray;
        this.rowStart = rowStart;
        this.rowEnd = rowEnd;
        this.colStart = colStart;
        this.colEnd = colEnd;
    }

    @Override
    public void run() {
        for(int i = rowStart ; i < rowEnd ; i++) {
            for(int j = colStart ; j < colEnd ; j++) {
                repaintArray.get(i).set(j, repaintArray.get(i).get(j) * 2);
            }
        }
    }
}
