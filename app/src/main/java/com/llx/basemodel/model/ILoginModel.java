package com.llx.basemodel.model;

import com.llx.basemodel.model.entity.BaseJson;
import com.llx.basemodel.model.entity.Key;
import com.llx.basemodel.model.entity.User;

import io.reactivex.Observable;

public interface ILoginModel {

    Observable<BaseJson<User>> getUser();

    Observable<Key> getPublicKey();

}
