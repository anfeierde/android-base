package com.cz1.rebase_android.network;

/**
 * Created by cz1 on 2017/2/8.
 */

public class ApiFactory {

    protected static final Object monitor = new Object();

    static Api sApi = null;

    public static boolean isDebug = true;

    // 单例模式 获取Api实例
    public static Api getApiSingleton() {
        synchronized (monitor) {
            if (sApi == null) {
                sApi = new RetrofitCfg().getApi();
            }
        }
        return sApi;
    }

}
