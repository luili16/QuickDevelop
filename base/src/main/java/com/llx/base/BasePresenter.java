package com.llx.base;

import android.arch.lifecycle.LifecycleObserver;
import android.content.Context;
import android.support.annotation.NonNull;

import com.google.common.base.Preconditions;
import com.llx.base.model.IModel;


/**
 *
 * @param <M> 所有的M必须要实现{@link IModel}
 * @param <V> 所有的V必须要实现{@link IView}
 *
 * BasePresenter继承了LifeCycleObserver,所以子类只需要复写其生命周期的方法就好了，
 * 这样的好处是在Presenter里面就可以感知Activity的生命周期
 */
public abstract class BasePresenter<M extends IModel,V extends IView> implements IPresenter,
        LifecycleObserver {

    protected M mModel;

    protected V mView;

    protected Context mContext;


    /**
     * 注意，传入的M和V不能是空,Context不能是Activity或Service
     * @param model model
     * @param view view
     */
    public BasePresenter(@NonNull M model, @NonNull V view,@NonNull Context context) {

        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(context);

        mModel = model;
        mView = view;
        mContext = context;
        // 每一个model都在这里面注入Context，方便后面的使用
        mModel.setContext(context);
    }

    /**
     * 某些情况下不需要model，直接传入View就可以了,但是这种情况下要注意model并没有被赋值，小心空指针！
     * Context不能是Activity或Service
     * @param view view
     */
    public BasePresenter(@NonNull V view,@NonNull Context context) {
        Preconditions.checkNotNull(view);
        mView = view;
        mContext = context;
    }
}
