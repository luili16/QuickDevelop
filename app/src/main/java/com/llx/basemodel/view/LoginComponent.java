package com.llx.basemodel.view;

import android.content.Context;

import com.llx.basemodel.model.ModuleProvider;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component (modules = {ViewModule.class, ModuleProvider.class})
@Singleton
public interface LoginComponent {

    Context getContext();

    void inject(LoginActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder context(Context context);

        Builder viewModule(ViewModule viewModule);

        LoginComponent build();
    }
}
