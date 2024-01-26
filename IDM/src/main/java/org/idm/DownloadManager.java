package org.idm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.idm.Config.Appconfig;
import org.idm.Models.fileinfo;

import java.io.File;

public class DownloadManager {

    @FXML
    private TableView<fileinfo> tableview;
    @FXML
    private TextField urltaxtfeild;
    public int index =0;
        @FXML
    void downloadbuttonclick(ActionEvent event) {
    String url=this.urltaxtfeild.getText().trim();
    String filename=url.substring(url.lastIndexOf("/")+1);
    String status="Starting";
    String action ="Open";
    String path= Appconfig.DOWNLOAD_PATH + File.separator + filename;
    fileinfo file =new fileinfo((index+1)+"",filename,url,status,action, path);
    this.index=this.index+1;
//Download Thread
            DownloadThread thread=new DownloadThread(file,this);
            this.tableview.getItems().add(Integer.parseInt(file.getIndex())-1,file);
            thread.start();
            
    }

    public void updateUI(fileinfo metaFile) {
        System.out.println(metaFile);
        fileinfo fileinfo = this.tableview.getItems().get(Integer.parseInt(metaFile.getIndex())-1);
        fileinfo.setStatus(metaFile.getStatus());
        this.tableview.refresh();
        System.out.println("--------------------------");

    }
    @FXML
    public void initialize(){
            System.out.println("view Initialized");

         TableColumn<fileinfo,String> sn=(TableColumn<fileinfo,String>) this.tableview.getColumns().get(0);
            sn.setCellValueFactory(p->{
                return p.getValue().indexProperty();
            });

        TableColumn<fileinfo,String> filename=(TableColumn<fileinfo,String>) this.tableview.getColumns().get(1);
        filename.setCellValueFactory(p->{
            return p.getValue().nameProperty();
        });

        TableColumn<fileinfo,String> fileurl=(TableColumn<fileinfo,String>) this.tableview.getColumns().get(2);
        fileurl.setCellValueFactory(p->{
            return p.getValue().urlProperty();
        });

        TableColumn<fileinfo,String> status=(TableColumn<fileinfo,String>) this.tableview.getColumns().get(3);
        status.setCellValueFactory(p->{
            return p.getValue().statusProperty();
        });

        TableColumn<fileinfo,String> action=(TableColumn<fileinfo,String>) this.tableview.getColumns().get(4);
        action.setCellValueFactory(p->{
            return p.getValue().actionProperty();
        });
        }
}
