package hello.leavesc.recyclerview.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import java.util.List;

import hello.leavesc.common2.CommonRecyclerViewAdapter;
import hello.leavesc.common2.CommonRecyclerViewHolder;
import hello.leavesc.recyclerview.R;
import hello.leavesc.recyclerview.model.Image;

/**
 * 作者：叶应是叶
 * 时间：2017/12/21 21:57
 * 说明：
 */
public class SnapAdapter extends CommonRecyclerViewAdapter<Image> {

    public SnapAdapter(Context context, List<Image> dataList) {
        super(context, dataList, R.layout.item_image);
    }

    @Override
    protected Image clone(Image data) {
        return new Image(data.getIndex(), data.getId());
    }

    @Override
    protected boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return dataList.get(oldItemPosition).getIndex() == newDataList.get(newItemPosition).getIndex();
    }

    @Override
    protected boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return dataList.get(oldItemPosition).getId() == newDataList.get(newItemPosition).getId();
    }

    @NonNull
    @Override
    protected Bundle getChangePayload(int oldItemPosition, int newItemPosition) {
        Bundle bundle = new Bundle();
        bundle.putInt("Id", newDataList.get(newItemPosition).getId());
        return bundle;
    }

    @Override
    protected void partialBindData(CommonRecyclerViewHolder holder, @NonNull Bundle bundle) {
        holder.setImageResource(R.id.imageView, bundle.getInt("Id"));
    }

    @Override
    protected void entirelyBindData(CommonRecyclerViewHolder holder, Image data) {
        holder.setImageResource(R.id.imageView, data.getId());
    }

}
