package org.example.JspUppgift.models;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Userbean implements Serializable {

    private List<String[]> data = null;
    private String fname;

    public Userbean(){};

    public List<String[]> getData() {
        return data;
    }

    public void setData(List<String[]> data) {
        this.data = data;
    }

}