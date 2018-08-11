package com.llx.base.model;

import com.llx.base.Configuration;

import java.io.File;

import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import okhttp3.HttpUrl;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository implements IRepository {

    private Retrofit mRetrofit;

    private RxCache mRxCache;

    public Repository() {
        Configuration config = Configuration.getConfig();
        HttpUrl baseUrl = config.getBaseUrl();
        mRetrofit = new Retrofit.Builder().
                baseUrl(baseUrl).
                addConverterFactory(GsonConverterFactory.create()).
                build();
        File cacheDir = config.getRxCacheDir();

        mRxCache = new RxCache.Builder().persistence(cacheDir,new GsonSpeaker());
    }


    @Override
    public <T> T getRetrofitService(Class<T> service, boolean useCache) {

        return mRetrofit.create(service);
    }

    @Override
    public <T> T getCacheService(Class<T> service, boolean useCache) {

        return mRxCache.using(service);
    }
}
