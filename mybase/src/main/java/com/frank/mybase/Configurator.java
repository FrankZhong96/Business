package com.frank.mybase;

import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import okhttp3.Interceptor;

/**
 * Created by 傅令杰 on 2017/3/29
 */

public final class Configurator {

    private static final HashMap<Object, Object> LATTE_CONFIGS = new HashMap<>();
    private static final Handler HANDLER = new Handler();
   // private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();
    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();

    private Configurator() {
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY, false);
        LATTE_CONFIGS.put(ConfigKeys.HANDLER, HANDLER);
    }

    static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final HashMap<Object, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    /**
     * 一些常用的框架初始化
     */
    public final void configure() {
        //日志初始化
        Logger.addLogAdapter(new AndroidLogAdapter());
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY, true);
        //Utils.init(Frank.getApplicationContext());
    }

    /**
     * 设置retrofit的base url
     * @param host
     * @return
     */
    public final Configurator withApiBaseUrl(String host) {
        LATTE_CONFIGS.put(ConfigKeys.BASE_URL, host);
        return this;
    }

    /**
     * 设置加载框延时 单位毫秒
     * @param delayed
     * @return
     */
    public final Configurator withLoaderDelayed(long delayed) {
        LATTE_CONFIGS.put(ConfigKeys.LOADER_DELAYED, delayed);
        return this;
    }

    /**
     * 设置OKhttp的超时时间 单位秒
     * @param s
     * @return
     */
    public final Configurator withOKhttpTimeOut(long s) {
        LATTE_CONFIGS.put(ConfigKeys.TIME_OUT, s);
        return this;
    }

    /**
     * 设置OKhttpOKhttp拦截器（单个）
     * @param interceptor
     * @return
     */
    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    /**
     * 设置OKhttpOKhttp拦截器（多个）
     * @param interceptors
     * @return
     */
    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    /**
     * 检查是否完成初始化
     */
    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigKeys.CONFIG_READY);
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = LATTE_CONFIGS.get(key);
//        if (value == null) {
//            throw new NullPointerException(key.toString() + " IS NULL");
//        }
        return (T) LATTE_CONFIGS.get(key);
    }
}
