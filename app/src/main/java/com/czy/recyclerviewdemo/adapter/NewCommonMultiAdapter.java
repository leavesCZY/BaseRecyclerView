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
 * 时间：2017/12/21 21:56
 * 说明：多布局
 */
public class NewCommonMultiAdapter extends CommonRecyclerViewAdapter<New> {

    public NewCommonMultiAdapter(Context context, List<New> dataList) {
        super(context, dataList, new CommonRecyclerViewAdapter.MultiTypeSupport<New>() {
            @Override
            public int getLayoutId(New item, int position) {
                return item.getIndex() % 2 == 0 ? R.layout.item_new_multi : R.layout.item_new;
            }
        });
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
        if (bundle.size() > 0) {
            bundle.putInt("Index", dataList.get(newItemPosition).getIndex());
        }
        return bundle;
    }

    @Override
    protected void partialBindData(CommonRecyclerViewHolder holder, @NonNull Bundle bundle) {
        if (bundle.size() > 0) {
            int index = bundle.getInt("Index");
            for (String key : bundle.keySet()) {
                switch (key) {
                    case "Title":
                        if (index % 2 == 0) {
                            holder.setText(R.id.tv_multi_title, bundle.getString(key));
                        } else {
                            holder.setText(R.id.tv_title, bundle.getString(key));
                        }
                        break;
                    case "Content":
                        if (index % 2 == 0) {
                            holder.setText(R.id.tv_multi_content, bundle.getString(key));
                        } else {
                            holder.setText(R.id.tv_content, bundle.getString(key));
                        }
                        break;
                }
            }
        }
    }

    @Override
    protected void entirelyBindData(CommonRecyclerViewHolder holder, New data) {
        if (data.getIndex() % 2 == 0) {
            holder.setText(R.id.tv_multi_title, data.getTitle())
                    .setText(R.id.tv_multi_content, data.getContent())
                    .setText(R.id.tv_multi_index, String.valueOf(data.getIndex()));
        } else {
            holder.setText(R.id.tv_title, data.getTitle())
                    .setText(R.id.tv_content, data.getContent())
                    .setText(R.id.tv_index, String.valueOf(data.getIndex()));
        }
    }

}
