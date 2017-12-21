package com.czy.recyclerviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * 作者：叶应是叶
 * 时间：2017/12/21 21:59
 * 说明：
 */
public class BaseActivity extends AppCompatActivity {

    protected void startActivity(Class cl) {
        startActivity(new Intent(this, cl));
    }

    protected void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
