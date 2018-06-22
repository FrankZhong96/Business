package com.frank.business.activity.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.frank.business.R;
import com.gyf.barlibrary.ImmersionBar;

/**
 * Created by Frank on 2018/6/20.
 *
 * @fuction Activity基类，提供公共的行为或事件
 */

public class BaseActivity extends AppCompatActivity {

    public String TAG;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getComponentName().getShortClassName();//类名
        //沉浸式状态栏
        //ImmersionBar.with(this).init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
