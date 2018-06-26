package com.frank.mybase.net;

import java.util.ArrayList;

import okhttp3.Interceptor;
import retrofit2.http.Streaming;

/**
 * Created by Frank on 2018/6/25.
 *
 * @fuction
 */

public class NetManager {
    private static NetManager sNetManager = null;

    //静态工厂方法
    public static NetManager getInstance() {
        if (sNetManager == null) {
            sNetManager = new NetManager();
        }
        return sNetManager;
    }

    /**
     * base url   BaseUrl要以/结尾
     */
    private String BASE_URL = "/";

    /**
     * OKhttp超时时间
     */
    private int TIME_OUT = 60;

    /**
     * 加载框延时 单位毫秒
     */
    private long LOAD_DELAYED = 500;

    /**
     * OKhttp拦截器
     */
    private ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();

    public String getBASE_URL() {
        return BASE_URL;
    }

    public void setBASE_URL(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }

    public int getTIME_OUT() {
        return TIME_OUT;
    }

    public void setTIME_OUT(int TIME_OUT) {
        this.TIME_OUT = TIME_OUT;
    }

    public long getLOAD_DELAYED() {
        return LOAD_DELAYED;
    }

    public void setLOAD_DELAYED(long LOAD_DELAYED) {
        this.LOAD_DELAYED = LOAD_DELAYED;
    }

    public ArrayList<Interceptor> getINTERCEPTORS() {
        return INTERCEPTORS;
    }

    public void setINTERCEPTORS(ArrayList<Interceptor> INTERCEPTORS) {
        this.INTERCEPTORS = INTERCEPTORS;
    }

}
