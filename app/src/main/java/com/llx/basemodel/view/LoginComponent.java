package com.llx.basemodel.view;

import com.llx.basemodel.model.ModuleProvider;

import dagger.Component;

@Component (modules = {ViewModule.class, ModuleProvider.class})
public interface LoginComponent {

    void inject(LoginActivity activity);
}
