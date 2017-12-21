package com.czy.recyclerviewdemo.model;

/**
 * 作者：叶应是叶
 * 时间：2017/12/21 21:55
 * 说明：
 */
public class New {

    private int index;

    private String title;

    private String content;

    public New(int index, String title, String content) {
        this.index = index;
        this.title = title;
        this.content = content;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
