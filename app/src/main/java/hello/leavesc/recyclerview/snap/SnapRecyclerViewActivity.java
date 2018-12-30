package hello.leavesc.recyclerview.snap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hello.leavesc.recyclerview.R;
import hello.leavesc.recyclerview.adapter.SnapAdapter;
import hello.leavesc.recyclerview.model.Image;

/**
 * 作者：叶应是叶
 * 时间：2017/12/21 22:02
 * 说明：
 */
public class SnapRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snap_recycler_view);
        RecyclerView rv_snap = (RecyclerView) findViewById(R.id.rv_snap);
        SnapAdapter snapAdapter = new SnapAdapter(this, getData());
        rv_snap.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        rv_snap.setLayoutManager(new LinearLayoutManager(this));
        rv_snap.setAdapter(snapAdapter);
//        LinearSnapHelper snapHelper = new LinearSnapHelper();
//        snapHelper.attachToRecyclerView(rv_snap);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(rv_snap);
    }

    private List<Image> getData() {
        List<Image> imageList = new ArrayList<>();
        imageList.add(new Image(0, R.drawable.drawable_1));
        imageList.add(new Image(1, R.drawable.drawable_0));
        imageList.add(new Image(2, R.drawable.drawable_1));
        imageList.add(new Image(3, R.drawable.drawable_0));
        imageList.add(new Image(4, R.drawable.drawable_1));
        imageList.add(new Image(5, R.drawable.drawable_0));
        imageList.add(new Image(6, R.drawable.drawable_1));
        imageList.add(new Image(7, R.drawable.drawable_0));
        return imageList;
    }

}
