package com.llx.basemodel.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;

import com.llx.base.BasePresenter;
import com.llx.basemodel.model.ILoginModel;
import com.llx.basemodel.model.entity.LoginData;
import com.llx.basemodel.view.ILoginView;

import timber.log.Timber;

class LoginPresenter extends BasePresenter<ILoginModel, ILoginView> {

    public LoginPresenter(@NonNull ILoginModel model, @NonNull ILoginView view) {
        super(model, view);
    }

    public LoginPresenter(@NonNull ILoginView view) {
        super(view);
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
