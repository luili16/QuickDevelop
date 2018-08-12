package com.llx.base;

import android.app.Application;
import android.content.Context;

import com.llx.base.model.Repository;

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
     * <p>
     * 在一个进程里面，所有的model都共享同一个框架的配置，
     * 这里面初始化Configuration里面的参数
     * <p>
     * 初始化日志打印的格式
     */
    private void init() {

        Configuration.Builder builder = new Configuration.Builder(mApp);
        IConfigurationInjector injector = ManifestParser.parse(mApp);

        if (injector != null) {
            builder = injector.inject(builder, mApp);
        }

        Configuration config = builder.build();

        if (BuildConfig.DEBUG) {
            Timber.plant(config.getDebugTrees().toArray(new Timber.Tree[]{}));
        } else {
            // 错误日志处理
            Timber.plant(config.getProduceTrees().toArray(new Timber.Tree[]{}));
        }
        // 初始化model层的网络请求层
        Repository.init(config);
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

    @Override
    public void onTerminate(Application app) {

    }
}
