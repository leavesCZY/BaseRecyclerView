package hello.leavesc.recyclerview.common;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hello.leavesc.common.CommonItemDecoration;
import hello.leavesc.common2.CommonRecyclerViewHolder;
import hello.leavesc.recyclerview.BaseActivity;
import hello.leavesc.recyclerview.R;
import hello.leavesc.recyclerview.adapter.NewCommonMultiAdapter;
import hello.leavesc.recyclerview.model.New;

/**
 * 作者：叶应是叶
 * 时间：2017/12/21 21:58
 * 说明：多布局
 */
public class CommonMultiRecyclerViewActivity extends BaseActivity {

    private List<New> newList;

    private NewCommonMultiAdapter newCommonMultiAdapter;

    private int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_multi_recycler_view);
        initData();
        RecyclerView rv_commonMultiDataList = (RecyclerView) findViewById(R.id.rv_commonMultiDataList);
        rv_commonMultiDataList.setLayoutManager(new LinearLayoutManager(this));
        newCommonMultiAdapter = new NewCommonMultiAdapter(this, newList);
        newCommonMultiAdapter.setClickListener(new CommonRecyclerViewHolder.OnClickListener() {
            @Override
            public void onClick(int position) {
                toast("单击" + "\n" + newList.get(position).getTitle() + "\n" + newList.get(position).getContent());
            }
        });
        newCommonMultiAdapter.setLongClickListener(new CommonRecyclerViewHolder.OnLongClickListener() {
            @Override
            public void onLongClick(int position) {
                toast("长按" + "\n" + newList.get(position).getTitle() + "\n" + newList.get(position).getContent());
            }
        });
        rv_commonMultiDataList.setAdapter(newCommonMultiAdapter);
        CommonItemDecoration commonItemDecoration = new CommonItemDecoration(ContextCompat.getDrawable(this, R.drawable.divider), LinearLayoutManager.VERTICAL);
        rv_commonMultiDataList.addItemDecoration(commonItemDecoration);
    }

    private void initData() {
        newList = new ArrayList<>();
        newList.add(new New(index++, "Hi", "你来自哪里"));
        newList.add(new New(index++, "叶应是叶", "好久不见"));
        newList.add(new New(index++, "叶", "该下班了吧"));
        newList.add(new New(index++, "Ye", "真是好玩啊"));
        newList.add(new New(index++, "leavesC", "不知火舞"));
        newList.add(new New(index++, "你好啊", "来来来"));
        newList.add(new New(index++, "leavesC", "咩咩咩咩喵喵喵喵"));
        newList.add(new New(index++, "嗨", "我呜呜呜呜"));
        newList.add(new New(index++, "天空之城", "很好听的歌啊"));
    }

    public void addData(View view) {
        newList.add(0, new New(index++, "叶应是叶", "leavesC " + index));
        newCommonMultiAdapter.setData(newList);
    }

    public void removeData(View view) {
        if (newList.size() > 0) {
            newList.remove(0);
            newCommonMultiAdapter.setData(newList);
        }
    }

    public void exchangeData(View view) {
        if (newList.size() >= 4) {
            New project0 = newList.get(0);
            New project1 = newList.get(1);
            New project2 = newList.get(3);
            newList.remove(project0);
            newList.remove(project1);
            newList.remove(project2);
            newList.add(0, project2);
            newList.add(0, project1);
            newList.add(0, project0);
            newCommonMultiAdapter.setData(newList);
        }
    }

    public void alterData(View view) {
        if (newList.size() > 0) {
            newList.get(0).setContent("hi " + index++);
            newCommonMultiAdapter.setData(newList);
        }
    }

}
