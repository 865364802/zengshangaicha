package com.ty.web;

import com.ty.web.QuanXian;

import java.util.ArrayList;
import java.util.List;

public class JiaoSe {
    private int id;
    private String title;
    List <QuanXian> quanXianList=new ArrayList();
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

    public List<QuanXian> getQuanXianList() {
        return quanXianList;
    }

    public void setQuanXianList(List<QuanXian> quanXianList) {
        this.quanXianList = quanXianList;
    }



}
