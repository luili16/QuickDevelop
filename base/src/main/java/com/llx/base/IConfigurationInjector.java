package com.llx.base;

import android.content.Context;

public interface IConfigurationInjector {
    Configuration.Builder  inject(Configuration.Builder builder, Context context);
}
