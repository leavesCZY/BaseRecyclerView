package com.czy.library.util;

import android.support.v7.widget.RecyclerView;

import com.czy.library.wrap.WrapRecyclerViewAdapter;

/**
 * 作者：叶应是叶
 * 时间：2017/12/21 21:53
 * 说明：
 */
public class RecyclerViewUtil {

    public static int getRecyclerViewAdapterPosition(RecyclerView recyclerView, int position) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null && adapter instanceof WrapRecyclerViewAdapter) {
            return position - ((WrapRecyclerViewAdapter) adapter).getHeaderViewCount();
        }
        return position;
    }

}
