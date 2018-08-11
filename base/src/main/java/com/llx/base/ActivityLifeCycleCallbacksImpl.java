package com.llx.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * 这里提供了一个监控activity生命周期
 */
public class ActivityLifeCycleCallbacksImpl implements Application.ActivityLifecycleCallbacks {

    private Deque<WeakReference<Activity>> mActivityStack;

    public ActivityLifeCycleCallbacksImpl() {
        mActivityStack = new ArrayDeque<>();
    }


    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

        mActivityStack.push(new WeakReference<>(activity));

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

        Iterator<WeakReference<Activity>> iterator = mActivityStack.iterator();
        while (iterator.hasNext()) {
            Activity existedActivity = iterator.next().get();
            // 移除已经销毁的activity
            if (existedActivity == null || existedActivity.equals(activity)) {
                iterator.remove();
            }
        }
    }
}
