package com.llx.base;

import android.arch.lifecycle.LifecycleObserver;
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
public class BasePresenter<M extends IModel,V extends IView> implements IPresenter,
        LifecycleObserver {

    protected M mModel;

    protected V mView;


    /**
     * 注意，传入的M和V不能是空
     * @param model model
     * @param view view
     */
    public BasePresenter(@NonNull M model, @NonNull V view) {

        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(view);

        mModel = model;
        mView = view;
    }

    /**
     * 某些情况下不需要model，直接传入View就可以了,但是这种情况下要注意model并没有被赋值，小心空指针！
     * @param view view
     */
    public BasePresenter(@NonNull V view) {
        Preconditions.checkNotNull(view);

        mView = view;
    }
}
