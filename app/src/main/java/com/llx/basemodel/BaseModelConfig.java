package com.llx.basemodel;

import android.content.Context;

import com.llx.base.Configuration;
import com.llx.base.IConfigurationInjector;

import okhttp3.HttpUrl;

public class BaseModelConfig implements IConfigurationInjector {

    @Override
    public Configuration.Builder inject(Configuration.Builder builder, Context context) {

        return builder.setBaseUrl(HttpUrl.parse("http://www.baidu.com")).
                setRxCacheDir(context.getCacheDir());
    }
}
