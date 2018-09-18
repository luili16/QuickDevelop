package com.llx.basemodel.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jakewharton.rxbinding2.view.RxView;
import com.llx.basemodel.R;
import com.llx.basemodel.model.ModuleProvider;
import com.llx.basemodel.presenter.ILoginPresenter;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class LoginActivity extends AppCompatActivity implements ILoginView {

    @Inject
    protected ILoginPresenter mPresenter;

    private CompositeDisposable mDisposables = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerLoginComponent.builder().
                setContext(getApplicationContext()).
                setLifeCycle(getLifecycle()).
                setRxPermissions(new RxPermissions(this)).
                setViewModule(new ViewModule(this)).
                setModelModule(new ModuleProvider()).
                        build().
                inject(this);
        getLifecycle().addObserver(mPresenter);
        mPresenter.begin();
        Disposable disposable = RxView.clicks(findViewById(R.id.button)).
                //throttleLast(2000,TimeUnit.SECONDS).
                subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        mPresenter.doLogin(null);
                    }
                });

        mDisposables.add(disposable);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.finish();
        // 避免内存泄露
        mDisposables.clear();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void startNewActivity(@NonNull Intent intent) {

    }
}
