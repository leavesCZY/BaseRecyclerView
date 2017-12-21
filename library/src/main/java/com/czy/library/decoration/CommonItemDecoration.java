package com.czy.library.decoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 作者：叶应是叶
 * 时间：2017/12/21 21:52
 * 说明：通用分隔线
 */
public class CommonItemDecoration extends RecyclerView.ItemDecoration{

    private int orientation = LinearLayoutManager.HORIZONTAL;

    private Drawable drawable;

    public CommonItemDecoration(Context context, int orientation) {
        this.orientation = orientation;
        int[] attrs = new int[]{android.R.attr.listDivider};
        TypedArray typedArray = context.obtainStyledAttributes(attrs);
        drawable = typedArray.getDrawable(0);
        typedArray.recycle();
    }

    public CommonItemDecoration(Drawable drawable, int orientation) {
        this.drawable = drawable;
        this.orientation = orientation;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (orientation == LinearLayoutManager.HORIZONTAL) {
            outRect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        } else if (orientation == LinearLayoutManager.VERTICAL) {
            outRect.set(0, 0, 0, drawable.getIntrinsicHeight());
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (orientation == LinearLayoutManager.HORIZONTAL) {
            drawVerticalDivider(c, parent);
        } else if (orientation == LinearLayoutManager.VERTICAL) {
            drawHorizontalDivider(c, parent);
        }
    }

    private void drawVerticalDivider(Canvas c, RecyclerView parent) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
//            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
//            //受 child layout_marginEnd 属性的影响
//            int left = child.getRight() + params.rightMargin;
            //不受 child layout_marginEnd 属性的影响，会直接绘制在 child 右侧
            int left = child.getRight();
            int top = child.getTop();
            int right = left + drawable.getIntrinsicWidth();
            int bottom = child.getBottom();
            drawable.setBounds(left, top, right, bottom);
            drawable.draw(c);
        }
    }

    private void drawHorizontalDivider(Canvas c, RecyclerView parent) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            int left = child.getLeft();
            //不受 child layout_marginBottom 属性的影响，会直接绘制在 child 底部
            int top = child.getBottom();
            int right = child.getRight();
            int bottom = top + drawable.getIntrinsicHeight();
            //会受 child layout_marginBottom 属性的影响
            //RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            //int top = child.getBottom() + params.bottomMargin;
            drawable.setBounds(left, top, right, bottom);
            drawable.draw(c);
        }
    }

}
