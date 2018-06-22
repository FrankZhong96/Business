package com.frank.business.application;

import android.app.Application;
import android.widget.BaseAdapter;

/**
 * Created by Frank on 2018/6/20.
 * @fuction 整个程序的入口，初始化工作，提供上下文环境
 */

public class BaseApplication extends Application {

    private static BaseApplication mApplication = null;

    //单例模式
    public static BaseApplication getInstance(){
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

}
