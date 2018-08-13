package com.llx.basemodel.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;

import com.llx.basemodel.model.ILoginModel;
import com.llx.basemodel.model.entity.LoginData;
import com.llx.basemodel.view.ILoginView;

import javax.inject.Inject;

import timber.log.Timber;

public class LoginPresenter implements LifecycleObserver {

    private Lifecycle mLifeCycle;

    @Inject
    protected ILoginModel mModel;

    @Inject
    protected ILoginView mView;

    @Inject
    protected Context mContext;

    @Inject
    public LoginPresenter() {
    }

    public void setLifeCycle(Lifecycle lifeCycle) {
        mLifeCycle = lifeCycle;
    }

    public void doLogin(LoginData data) {
        // 这里面实现登录的逻辑
    }

    // ---- 测试lifeCycle

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Timber.d("onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Timber.d("onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Timber.d("onPause");
    }
}
