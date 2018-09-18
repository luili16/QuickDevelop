package com.llx.basemodel.model;

import android.content.Context;

import com.llx.basemodel.model.entity.BaseJson;
import com.llx.basemodel.model.entity.Key;
import com.llx.basemodel.model.entity.User;

import javax.inject.Inject;

import io.reactivex.Observable;

class LoginModel implements ILoginModel {

    private Context mContext;
    //private Repository mRepository;

    LoginModel(Context context) {
        mContext = context;
        //mRepository = repository;
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
