package org.idm.Models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class fileinfo {

    private SimpleStringProperty name =new SimpleStringProperty();
    private SimpleStringProperty index =new SimpleStringProperty();
    private SimpleStringProperty url=new SimpleStringProperty();
    private SimpleStringProperty status=new SimpleStringProperty(); //Downloading, Done, Starting
    private SimpleStringProperty action=new SimpleStringProperty();
    private SimpleStringProperty path=new SimpleStringProperty();

    public fileinfo(String index, String name, String url, String status, String action, String path) {
        this.index.set(index);
        this.name.set(name);
        this.url.set(url);
        this.status.set(status);
        this.action.set(action);
        this.path.set(path);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getIndex() {
        return index.get();
    }

    public SimpleStringProperty indexProperty() {
        return index;
    }

    public String getUrl() {
        return url.get();
    }

    public SimpleStringProperty urlProperty() {
        return url;
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public SimpleStringProperty actionProperty() {
        return action;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setIndex(String index) {
        this.index.set(index);
    }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public void setAction(String action) {
        this.action.set(action);
    }

    public String getPath() {
        return path.get();
    }

    public void setPath(String path) {
        this.path.set(path);
    }

    @Override
    public String toString() {
        return "fileinfo{" +
                "name=" + name +
                ", index=" + index +
                ", url=" + url +
                ", status=" + status +
                ", action=" + action +
                ", path=" + path +
                '}';
    }
}
//https://dl.downloadly.ir/Files/Software/Java_SE_Runtime_Environment_10.0.2_x64_Downloadly.ir.rar
//https://dl.downloadly.ir/Files/Software/AnyDesk_7.1.7_Multilingual_Downloadly.ir.rar
//https://dl.downloadly.ir/Files/Software/Java_SE_Runtime_Environment_10.0.2_x64_Downloadly.ir.rar