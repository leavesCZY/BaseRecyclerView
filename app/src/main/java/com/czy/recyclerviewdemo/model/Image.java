package com.czy.recyclerviewdemo.model;

import android.support.annotation.DrawableRes;

/**
 * 作者：叶应是叶
 * 时间：2017/12/21 21:55
 * 说明：
 */
public class Image {

    private int index;

    @DrawableRes
    private int id;

    public Image(int index, int id) {
        this.index = index;
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
