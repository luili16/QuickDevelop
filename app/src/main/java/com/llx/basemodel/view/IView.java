package com.llx.basemodel.view;

import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * 封装基础的view所需要的基础操作
 */
public interface IView {


    void showLoading();

    void hideLoading();

    void showMessage();

    /**
     * 跳转到一个新的activity
     */
    void startNewActivity(@NonNull Intent intent);

    /**
     * 结束这个View，因为不能确定是谁实现了IView这个接口，所以这个finish是抽象的，
     * 只是关闭这个view所代表的页面
     */
    void finish();

}
