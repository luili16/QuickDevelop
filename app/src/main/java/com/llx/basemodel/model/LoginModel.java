package com.llx.basemodel.model;

import com.llx.basemodel.model.entity.BaseJson;
import com.llx.basemodel.model.entity.Key;
import com.llx.basemodel.model.entity.User;

import javax.inject.Inject;

import io.reactivex.Observable;

class LoginModel implements ILoginModel {



    LoginModel() {
        super();
    }

    @Override
    public Observable<BaseJson<User>> getUser() {

        return null;
    }

    @Override
    public Observable<Key> getPublicKey() {

        return null;
    }
}
