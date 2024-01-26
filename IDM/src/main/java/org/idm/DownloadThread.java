package org.idm;

import org.idm.Models.fileinfo;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadThread extends Thread{
    private fileinfo file;
    DownloadManager manager;
    public DownloadThread(fileinfo file, DownloadManager manager){
        this.file=file;
        this.manager=manager;
    }

    public void run(){
        this.file.setStatus("Downloading");
        this.manager.updateUI(this.file);

        try {
            Files.copy(new URL(this.file.getUrl()).openStream(),Paths.get(this.file.getPath()));
            this.file.setStatus("Done");
        }catch (IOException e){
            this.file.setStatus("Failed");
            System.out.println("Downloading Error");
            e.printStackTrace();
        }


    }
}
