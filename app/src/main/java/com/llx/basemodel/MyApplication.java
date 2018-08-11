package com.llx.basemodel;

import android.app.Application;
import android.content.Context;

import com.llx.base.AppDelegate;
import com.llx.base.IAppDelegate;

public class MyApplication extends Application {

    IAppDelegate mAppDelegate;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        if (mAppDelegate == null) {
            mAppDelegate = new AppDelegate();
        }

        mAppDelegate.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppDelegate.onCreate(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        mAppDelegate.onTerminate(this);
    }
}
