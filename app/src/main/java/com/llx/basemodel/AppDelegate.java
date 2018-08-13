package com.llx.basemodel;

import android.app.Application;
import android.content.Context;

import com.llx.base.BuildConfig;

import timber.log.Timber;

public class AppDelegate {

    private Application mApp;

    public void attachBaseContext(Context base) {

    }

    public void onCreate(Application app) {
        mApp = app;

        init();
    }

    /**
     * 常用框架的初始化
     * <p>
     * 在一个进程里面，所有的model都共享同一个框架的配置，
     * 这里面初始化Configuration里面的参数
     * <p>
     * 初始化日志打印的格式
     */
    private void init() {



        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            // 错误日志处理
            Timber.plant();
        }
    }

    /**
     * 代理注册ActivityLifecycleCallbacks
     *
     * @param callbacks
     */
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callbacks) {
        mApp.registerActivityLifecycleCallbacks(callbacks);
    }

    public Context getAppContext() {
        return mApp.getApplicationContext();
    }


    public void onTerminate(Application app) {

    }
}
