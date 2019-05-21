package com.ty.web;

import java.util.ArrayList;
import java.util.List;

public class YongHu {
    private int id;
    private  String title;
    List <JiaoSe> jiaoseList=new ArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<JiaoSe> getJiaoseList() {
        return jiaoseList;
    }

    public void setJiaoseList(List<JiaoSe> jiaoseList) {
        this.jiaoseList = jiaoseList;
    }
}
