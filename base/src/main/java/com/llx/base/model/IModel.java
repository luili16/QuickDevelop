package com.llx.base.model;

import android.content.Context;

/**
 * model层所具有的抽象方法
 */
public interface IModel {

    /**
     * 每个Model，都需要持有一个Context，
     * @param context applicationContext
     */
    void setContext(Context context);
}
