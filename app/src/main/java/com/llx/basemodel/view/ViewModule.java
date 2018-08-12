package com.llx.basemodel.view;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {

    private ILoginView mLoginView;

    private Context mContext;

    public ViewModule(ILoginView loginView,Context context) {
        mLoginView = loginView;
        mContext = context;
    }

    @Provides
    ILoginView provideILoginView() {
        return mLoginView;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}
