package AdvancedJava.Concurrency.ExecutorsAndCallables.DownloadManager;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<String> downloadLinks = Arrays.asList("Link1", "Link2", "Link3", "Link4", "Link5");
        DownloadManager downloadManager = new DownloadManager(downloadLinks);

        downloadManager.download();
    }
}
