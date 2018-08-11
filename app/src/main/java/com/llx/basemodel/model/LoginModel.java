package com.llx.basemodel.model;

import com.llx.basemodel.model.entity.BaseJson;
import com.llx.basemodel.model.entity.Key;
import com.llx.basemodel.model.entity.User;

import io.reactivex.Observable;

class LoginModel implements ILoginModel {



    @Override
    public Observable<BaseJson<User>> getUser() {
        return null;
    }

    @Override
    public Observable<Key> getPublicKey() {
        return null;
    }
}
