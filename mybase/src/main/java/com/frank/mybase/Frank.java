package com.frank.mybase;

import android.content.Context;
import android.os.Handler;

/**
 * Created by 傅令杰 on 2017/3/29
 */

public final class Frank {

    /**
     * MyBase 配置初始化
     * @param context
     * @return
     */
    public static Configurator init(Context context) {
        Configurator.getInstance()
                .getLatteConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    /**
     * 配置相关KEY
     * @return
     */
    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    /**
     * 获取相应的KEY
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    /**
     * 获取上下文环境
     * @return
     */
    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }

    /**
     * 获取Handler
     * @return
     */
    public static Handler getHandler() {
        return getConfiguration(ConfigKeys.HANDLER);
    }
}