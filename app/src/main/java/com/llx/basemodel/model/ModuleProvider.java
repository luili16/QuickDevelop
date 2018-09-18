package com.llx.basemodel.model;


import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class ModuleProvider {

    //private Repository mRepository;

    public ModuleProvider() {
        //mRepository = Repository.instance();
    }

    @Provides
    public ILoginModel provideLoginModel(Context context) {
        return new LoginModel(context);
    }


}
