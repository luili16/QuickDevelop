package com.llx.base;


import android.app.Application;
import android.content.Context;

/**
 * 代理Application的实现，这样的好处是不用侵入式的
 * 继承Application,为继承其他sdk所提供的application做准备
 */
public interface IAppDelegate {

    void attachBaseContext(Context base);

    void onCreate(Application app);

    void onTerminate(Application app);

}
