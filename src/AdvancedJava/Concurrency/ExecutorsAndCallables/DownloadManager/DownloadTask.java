package AdvancedJava.Concurrency.ExecutorsAndCallables.DownloadManager;

public class DownloadTask implements Runnable {
    String downloadLink;

    public DownloadTask(String downloadLink) {
        this.downloadLink = downloadLink;
    }
    @Override
    public void run() {
        for(int i = 0 ; i <= 100 ; i += 10) {
            System.out.println("Progress for " + downloadLink + " " + i + " % ");
        }
        System.out.println("Download complete for " + downloadLink);
    }
}
