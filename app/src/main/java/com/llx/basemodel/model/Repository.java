package com.llx.basemodel.model;

import android.content.Context;

import com.llx.base.Configuration;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import okhttp3.HttpUrl;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Repository这个类设计的意图就是对Model层提供数据访问的支持
 *
 * 包内可见，单例
 */
public class Repository {

    private static Repository sInstance;

    public static void init(Context context) {
        if (sInstance != null) {
            throw new IllegalStateException("Repository can only init once");
        }
        sInstance = new Repository(context);
    }

    static Repository instance() {

        if (sInstance == null) {
            throw new IllegalStateException("call Repository.init(Configuration) before instance()");
        }

        return sInstance;
    }

    private Retrofit mRetrofit;

    private RxCache mRxCache;

    private Repository(Context context) {
        HttpUrl baseUrl = HttpUrl.parse(Api.APP_DOMAIN);
        if (baseUrl == null) {
            Timber.d("unknown baseUrl");
            return;
        }

        mRetrofit = new Retrofit.Builder().
                baseUrl(baseUrl).
                addConverterFactory(GsonConverterFactory.create()).
                build();
        File cacheDir = context.getCacheDir();

        mRxCache = new RxCache.Builder().persistence(cacheDir,new GsonSpeaker());
    }

    /**
     * 获得Retrofit的服务接口
     *
     * useCache为true的含义是每次调用getRetrofitService这个方法都会将获得Service缓存起来，下次
     * 如果调用相同的service，就直接返回缓存的service，false就是不检查缓存，每次都生成一个新的service
     * @param service 具体的Service
     * @param useCache true 使用缓存，false 不使用缓存
     * @param <T> T
     * @return Retrofit的服务
     */
    synchronized static   <T> T getRetrofitService(Class<T> service, boolean useCache) {
        // 忽略useCache的实现，暂时不考虑不使用缓存对性能带来的影响

        return sInstance.mRetrofit.create(service);
    }

    /**
     * 获得RxCache服务的接口
     *
     * useCache为true的含义是每次调用getCacheService这个方法都会将获得Service缓存起来，下次
     * 如果调用相同的service，就直接返回缓存的service，false就是不检查缓存，每次都生成一个新的service
     * @param service 具体的service
     * @param useCache true 使用缓存，false 不使用缓存
     * @param <T> T
     * @return Cache服务
     */
    synchronized static  <T> T getCacheService(Class<T> service, boolean useCache) {

        return sInstance.mRxCache.using(service);
    }
}
