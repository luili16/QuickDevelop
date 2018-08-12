package com.llx.base;

import android.support.annotation.NonNull;
import android.util.Log;

import timber.log.Timber;

/**
 *  崩溃日志上传，目前先抽离出接口
 *
 *  待实现日志上传的功能以后再回头实现这里
 */
public class ErrorLogReportingTree extends Timber.Tree {




    @Override
    protected void log(int priority, String tag, @NonNull String message, Throwable t) {

        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            // 生产环境下忽略调试日志的输出
            return;
        }


    }
}
