package com.llx.basemodel.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.llx.basemodel.R;
import com.llx.basemodel.model.ModuleProvider;
import com.llx.basemodel.presenter.LoginPresenter;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @Inject
    protected LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerLoginComponent.builder().
                viewModule(new ViewModule(this,getApplicationContext())).
                moduleProvider(new ModuleProvider()).build().
                inject(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage() {

    }

    @Override
    public void startNewActivity(@NonNull Intent intent) {

    }
}
