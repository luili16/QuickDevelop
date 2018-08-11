package com.llx.base;

import android.content.Context;

public interface IConfiguration {
    void injectConfig(Configuration.Builder builder, Context context);
}
