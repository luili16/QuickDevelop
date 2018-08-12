package com.llx.basemodel.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.annotation.NonNull;

import com.llx.base.BasePresenter;
import com.llx.basemodel.model.ILoginModel;
import com.llx.basemodel.model.entity.LoginData;
import com.llx.basemodel.view.ILoginView;

import javax.inject.Inject;

import timber.log.Timber;

public class LoginPresenter extends BasePresenter<ILoginModel, ILoginView> {

    @Inject
    public LoginPresenter(@NonNull ILoginModel model,
                          @NonNull ILoginView view,
                          @NonNull Context context) {
        super(model, view, context);
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


    @Override
    public void onStart() {
    }

    @Override
    public void onDestroy() {
    }
}
