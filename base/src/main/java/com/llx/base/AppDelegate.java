package com.llx.base;

import android.app.Application;
import android.content.Context;

import timber.log.Timber;

public class AppDelegate implements IAppDelegate {

    private Application mApp;



    @Override
    public void attachBaseContext(Context base) {

    }

    @Override
    public void onCreate(Application app) {
        mApp = app;

        init();
    }

    /**
     * 常用框架的初始化
     *
     *  在一个进程里面，所有的model都共享同一个框架的配置，
     *  这里面初始化Configuration里面的参数
     *
     *  初始化日志打印的格式
     *
     */
    private void init() {

        IConfiguration config = ManifestParser.parse(mApp);

        Configuration.Builder builder = new Configuration.Builder();

        if (config != null) {
            config.injectConfig(builder, mApp);
        }

        builder.innerBuild();
        Configuration conn = Configuration.getConfig();

        if (BuildConfig.DEBUG) {
            Timber.plant(conn.getDebugTrees().toArray(new Timber.Tree[]{}));
        } else {
            // 错误日志处理
            Timber.plant(conn.getProduceTrees().toArray(new Timber.Tree[]{}));
        }
    }

    /**
     * 代理注册ActivityLifecycleCallbacks
     * @param callbacks
     */
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callbacks) {
        mApp.registerActivityLifecycleCallbacks(callbacks);
    }

    public Context getAppContext() {
        return mApp.getApplicationContext();
    }

    @Override
    public void onTerminate(Application app) {

    }
}
