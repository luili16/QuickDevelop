package com.llx.basemodel.model;

import com.llx.basemodel.model.ILoginModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleProvider {

    @Provides
    ILoginModel provideLoginModel() {
        return new LoginModel();
    }

}
