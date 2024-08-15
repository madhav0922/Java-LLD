package AdvancedJava.Concurrency.ExecutorsAndCallables.DownloadManager;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadManager {
    List<String> downloadLinks;
    ExecutorService executorService;

    public DownloadManager(List<String> downloadLinks) {
        this.downloadLinks = downloadLinks;
        this.executorService = Executors.newFixedThreadPool(5);
    }

    public void download() {
        // Denotes the percentage of download
        for(String link : downloadLinks) {
            executorService.submit(new DownloadTask(link));
        }
    }
}
