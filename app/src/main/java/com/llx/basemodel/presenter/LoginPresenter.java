package com.llx.basemodel.presenter;

import android.Manifest;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;

import com.llx.basemodel.model.ILoginModel;
import com.llx.basemodel.model.entity.LoginData;
import com.llx.basemodel.view.ILoginView;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import timber.log.Timber;

public class LoginPresenter implements ILoginPresenter {

    @Inject
    protected Lifecycle mLifeCycle;

    @Inject
    protected ILoginModel mModel;

    @Inject
    protected ILoginView mView;

    @Inject
    protected Context mContext;

    @Inject
    protected RxPermissions mRxPermissions;

    private Disposable disposable;

    @Inject
    public LoginPresenter() {
    }

    @Override
    public void doLogin(LoginData data) {
        // 这里面实现登录的逻辑

        disposable = mRxPermissions.
                request(Manifest.permission.CAMERA).
                flatMap(new Function<Boolean, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Boolean granted) throws Exception {


                        if (granted) {
                            Timber.d("permission granted!");

                            if (mLifeCycle.getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {

                            }

                        } else {
                            Timber.d("permission not granted!");
                            disposable.dispose();
                        }

                        return Observable.just("Hello");
                    }
                }).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String granted) throws Exception {
                        Timber.d("item is %s",granted);
                        mView.showMessage();
                    }
                });


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
    public void begin() {
    }

    @Override
    public void finish() {
    }
}
