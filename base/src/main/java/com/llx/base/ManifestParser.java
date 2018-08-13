package com.llx.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;


class ManifestParser {

    private static final String KEY = "ConfigurationKey";

    public static IConfigurationInjector parse(Context context) {

        String packageName = context.getPackageName();
        try {
            ApplicationInfo appInfo = context.getPackageManager().
                    getApplicationInfo(packageName, PackageManager.GET_META_DATA);
            if (appInfo.metaData != null) {
                for (String key : appInfo.metaData.keySet()) {
                    if (KEY.equals(key)) {
                        return parseModule(appInfo.metaData.getString(key));
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse ConfigModule", e);
        }
        return null;
    }

    private static IConfigurationInjector parseModule(String className) {

        try {
            Class<?> aClass = Class.forName(className);

            Object ins = aClass.newInstance();
            if (!(ins instanceof IConfigurationInjector)) {
                throw new RuntimeException("Expected instanceof ConfigModule, but found: " + ins);
            }

            return (IConfigurationInjector) ins;
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Unable to find Configuration implementation", e);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("Unable to instantiate Configuration implementation", e);
        }
    }

}
