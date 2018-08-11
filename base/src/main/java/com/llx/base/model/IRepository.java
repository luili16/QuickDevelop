package com.llx.base.model;

/**
 * 封装了model层获取数据的来源
 */
public interface IRepository {


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
    <T> T getRetrofitService(Class<T> service,boolean useCache);

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
    <T> T getCacheService(Class<T> service,boolean useCache);
}
