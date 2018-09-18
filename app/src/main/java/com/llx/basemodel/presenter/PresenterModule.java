package com.llx.basemodel.presenter;

import dagger.Binds;
import dagger.BindsInstance;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class PresenterModule {

    @Binds
    public abstract ILoginPresenter provideLoginPresenter(LoginPresenter presenter);
}
