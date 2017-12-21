package com.czy.recyclerviewdemo.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.czy.library.common.CommonRecyclerViewAdapter;
import com.czy.library.common.CommonRecyclerViewHolder;
import com.czy.recyclerviewdemo.R;
import com.czy.recyclerviewdemo.model.New;

import java.util.List;

/**
 * 作者：叶应是叶
 * 时间：2017/12/21 21:55
 * 说明：单个布局
 */
public class NewCommonAdapter extends CommonRecyclerViewAdapter<New> {

    public NewCommonAdapter(Context context, List<New> dataList) {
        super(context, dataList, R.layout.item_new);
    }

    @Override
    protected New clone(New data) {
        return new New(data.getIndex(), data.getTitle(), data.getContent());
    }

    @Override
    protected boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return dataList.get(oldItemPosition).getIndex() == newDataList.get(newItemPosition).getIndex();
    }

    @Override
    protected boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        String title = dataList.get(oldItemPosition).getTitle();
        String content = dataList.get(oldItemPosition).getContent();
        String newTitle = newDataList.get(newItemPosition).getTitle();
        String newContent = newDataList.get(newItemPosition).getContent();
        return title.equals(newTitle) && content.equals(newContent);
    }

    @NonNull
    @Override
    protected Bundle getChangePayload(int oldItemPosition, int newItemPosition) {
        Bundle bundle = new Bundle();
        String title = dataList.get(oldItemPosition).getTitle();
        String content = dataList.get(oldItemPosition).getContent();
        String newTitle = newDataList.get(newItemPosition).getTitle();
        String newContent = newDataList.get(newItemPosition).getContent();
        if (!title.equals(newTitle)) {
            bundle.putString("Title", newTitle);
        }
        if (!content.equals(newContent)) {
            bundle.putString("Content", newContent);
        }
        return bundle;
    }

    @Override
    protected void partialBindData(CommonRecyclerViewHolder holder, @NonNull Bundle bundle) {
        for (String key : bundle.keySet()) {
            switch (key) {
                case "Title":
                    holder.setText(R.id.tv_title, bundle.getString(key));
                    break;
                case "Content":
                    holder.setText(R.id.tv_content, bundle.getString(key));
                    break;
            }
        }
    }

    @Override
    protected void entirelyBindData(CommonRecyclerViewHolder holder, New data) {
        holder.setText(R.id.tv_title, data.getTitle())
                .setText(R.id.tv_content, data.getContent());
    }

}
