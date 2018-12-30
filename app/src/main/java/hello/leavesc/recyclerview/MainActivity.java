package hello.leavesc.recyclerview;

import android.os.Bundle;
import android.view.View;

import hello.leavesc.recyclerview.common.CommonMultiRecyclerViewActivity;
import hello.leavesc.recyclerview.common.CommonRecyclerViewActivity;
import hello.leavesc.recyclerview.snap.SnapRecyclerViewActivity;
import hello.leavesc.recyclerview.wrap.WrapRecyclerViewActivity;

/**
 * 作者：叶应是叶
 * 时间：2017/12/21 21:47
 * 说明：
 * GitHub: https://github.com/leavesC
 * 简书： http://www.jianshu.com/u/9df45b87cfdf
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startCommonRecyclerView(View view) {
        startActivity(CommonRecyclerViewActivity.class);
    }

    public void startCommonMultiRecyclerView(View view) {
        startActivity(CommonMultiRecyclerViewActivity.class);
    }

    public void startWrapRecyclerView(View view) {
        startActivity(WrapRecyclerViewActivity.class);
    }

    public void startSnapRecyclerView(View view) {
        startActivity(SnapRecyclerViewActivity.class);
    }

}
