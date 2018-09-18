package com.llx.basemodel.presenter;

import android.arch.lifecycle.LifecycleObserver;

/**
 * Presenter层所共有的抽象方法
 *
 */
public interface IPresenter extends LifecycleObserver {

    /**
     * 此方法会被View层调用，代表View层已经初始化结束，
     * Presenter层可以进行自己的初始化逻辑了
     */
    void begin();

    /**
     * 此方法会被View层调用，代表View层已经销毁，Presenter层
     * 在这里可以进行一些内存清理工作
     */
    void finish();


}
