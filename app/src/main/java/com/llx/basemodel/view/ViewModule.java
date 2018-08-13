package com.llx.basemodel.view;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {

    private ILoginView mLoginView;

    public ViewModule(ILoginView loginView) {
        mLoginView = loginView;
    }



    @Provides
    ILoginView provideILoginView() {
        return mLoginView;
    }
}
