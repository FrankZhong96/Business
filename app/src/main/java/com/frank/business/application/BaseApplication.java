package com.frank.business.application;

import android.app.Application;

import com.frank.business.R;
import com.frank.mybase.Frank;
import com.frank.mybase.net.interceptors.DebugInterceptor;

/**
 * Created by Frank on 2018/6/20.
 * @fuction 整个程序的入口，初始化工作，提供上下文环境
 */

public class BaseApplication extends Application {

    private static BaseApplication mApplication = null;

    //单例模式
    public static BaseApplication getInstance(){
        if (mApplication == null){
            mApplication = new BaseApplication();
        }
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        Frank.init(this)
                .withLoaderDelayed(1000)
                .withApiBaseUrl("https://http://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .withOKhttpTimeOut(60)
                .configure();
    }

}
