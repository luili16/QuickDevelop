package com.llx.base.model;

import android.content.Context;
import android.support.annotation.CallSuper;

import javax.inject.Inject;

public class BaseModel implements IModel {

    protected Context mContext;

    protected Repository mRepository;

    public BaseModel() {
        mRepository = Repository.instance();
    }

    @Override
    public void setContext(Context context) {
        mContext = context;
    }


}
