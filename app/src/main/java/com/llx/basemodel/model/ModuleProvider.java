package com.llx.basemodel.model;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleProvider {

    @Provides
    @Singleton
    ILoginModel provideLoginModel() {
        return new LoginModel();
    }
}
