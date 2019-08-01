package com.sz.dzh.dviewsummary.bean;

/**
 * Created by dengzh on 2018/4/10.
 * 活动类型
 */

public class TabBean {


    private int id;
    private String typename;
    private String picture;


    public TabBean(int id, String typename, String picture) {
        this.id = id;
        this.typename = typename;
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

}
