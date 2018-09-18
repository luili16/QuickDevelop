package com.llx.basemodel.view;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;

import com.llx.basemodel.model.ModuleProvider;
import com.llx.basemodel.presenter.PresenterModule;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component (modules = {ViewModule.class, ModuleProvider.class, PresenterModule.class})
@Singleton
public interface LoginComponent {

    void inject(LoginActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder setContext(Context context);

        @BindsInstance
        Builder setLifeCycle(Lifecycle lifecycle);

        @BindsInstance
        Builder setRxPermissions(RxPermissions rxPermissions);

        Builder setViewModule(ViewModule viewModule);

        Builder setModelModule(ModuleProvider moduleProvider);

        LoginComponent build();
    }
}
