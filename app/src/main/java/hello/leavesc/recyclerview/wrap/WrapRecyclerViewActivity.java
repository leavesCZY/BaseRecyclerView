package hello.leavesc.recyclerview.wrap;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hello.leavesc.common.CommonItemDecoration;
import hello.leavesc.common2.CommonRecyclerViewHolder;
import hello.leavesc.recyclerview.BaseActivity;
import hello.leavesc.recyclerview.R;
import hello.leavesc.recyclerview.adapter.NewCommonAdapter;
import hello.leavesc.recyclerview.model.New;
import hello.leavesc.util.RecyclerViewUtil;
import hello.leavesc.wrap.WrapRecyclerViewAdapter;

/**
 * 作者：叶应是叶
 * 时间：2017/12/21 22:04
 * 说明：
 */
public class WrapRecyclerViewActivity extends BaseActivity {

    private int headerIndex = 0;

    private int footerIndex = 0;

    private RecyclerView rv_wrapDataList;

    private WrapRecyclerViewAdapter wrapRecyclerViewAdapter;

    private List<New> newList;

    private List<View> headerViewList = new ArrayList<>();

    private List<View> footerViewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrap_recycler_view);
        rv_wrapDataList = (RecyclerView) findViewById(R.id.rv_wrapDataList);
        initData();
        NewCommonAdapter adapter = new NewCommonAdapter(this, newList);
        adapter.setClickListener(new CommonRecyclerViewHolder.OnClickListener() {
            @Override
            public void onClick(int position) {
                New aNew = newList.get(RecyclerViewUtil.getRecyclerViewAdapterPosition(rv_wrapDataList, position));
                toast("点击" + "\n" + aNew.getTitle() + "\n" + aNew.getContent());
            }
        });
        adapter.setLongClickListener(new CommonRecyclerViewHolder.OnLongClickListener() {
            @Override
            public void onLongClick(int position) {
                New aNew = newList.get(RecyclerViewUtil.getRecyclerViewAdapterPosition(rv_wrapDataList, position));
                toast("长按" + "\n" + aNew.getTitle() + "\n" + aNew.getContent());
            }
        });
        wrapRecyclerViewAdapter = new WrapRecyclerViewAdapter(adapter);
        rv_wrapDataList.setLayoutManager(new LinearLayoutManager(this));
        rv_wrapDataList.setAdapter(wrapRecyclerViewAdapter);
        CommonItemDecoration commonItemDecoration = new CommonItemDecoration(ContextCompat.getDrawable(this, R.drawable.divider), LinearLayoutManager.VERTICAL);
        rv_wrapDataList.addItemDecoration(commonItemDecoration);
    }

    private void initData() {
        newList = new ArrayList<>();
        int index = 1;
        newList.add(new New(index++, "Hi", "你来自哪里"));
        newList.add(new New(index++, "叶应是叶", "好久不见"));
        newList.add(new New(index++, "叶", "该下班了吧"));
        newList.add(new New(index++, "Ye", "真是好玩啊"));
        newList.add(new New(index++, "leavesC", "不知火舞"));
        newList.add(new New(index++, "你好啊", "来来来"));
        newList.add(new New(index++, "leavesC", "咩咩咩咩喵喵喵喵"));
        newList.add(new New(index++, "嗨", "我呜呜呜呜"));
        newList.add(new New(index, "天空之城", "很好听的歌啊"));
    }

    public void addHeader(View view) {
        wrapRecyclerViewAdapter.addHeaderView(getHeaderView());
        rv_wrapDataList.smoothScrollToPosition(0);
    }

    public void removeHeader(View view) {
        if (headerViewList.size() > 0) {
            wrapRecyclerViewAdapter.removeHeaderView(headerViewList.get(headerViewList.size() - 1));
            headerViewList.remove(headerViewList.size() - 1);
        }
    }

    public void addFooter(View view) {
        wrapRecyclerViewAdapter.addFooterView(getFooterView());
        rv_wrapDataList.smoothScrollToPosition(wrapRecyclerViewAdapter.getItemCount());
    }

    public void removeFooter(View view) {
        if (footerViewList.size() > 0) {
            wrapRecyclerViewAdapter.removeFooterView(footerViewList.get(footerViewList.size() - 1));
            footerViewList.remove(footerViewList.size() - 1);
        }
    }

    private View getHeaderView() {
        View view_header = getLayoutInflater().inflate(R.layout.layout_header, rv_wrapDataList, false);
        TextView tv_header = (TextView) view_header.findViewById(R.id.tv_hint);
        tv_header.setText("Header " + headerIndex++);
        headerViewList.add(view_header);
        return view_header;
    }

    private View getFooterView() {
        View view_footer = getLayoutInflater().inflate(R.layout.layout_footer, rv_wrapDataList, false);
        TextView tv_footer = (TextView) view_footer.findViewById(R.id.tv_hint);
        tv_footer.setText("Footer " + footerIndex++);
        footerViewList.add(view_footer);
        return view_footer;
    }

}
