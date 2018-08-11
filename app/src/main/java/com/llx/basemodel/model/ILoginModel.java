package com.llx.basemodel.model;

import com.llx.base.model.IModel;
import com.llx.basemodel.model.entity.BaseJson;
import com.llx.basemodel.model.entity.Key;
import com.llx.basemodel.model.entity.User;

import io.reactivex.Observable;

public interface ILoginModel extends IModel {

    Observable<BaseJson<User>> getUser();

    Observable<Key> getPublicKey();




}
