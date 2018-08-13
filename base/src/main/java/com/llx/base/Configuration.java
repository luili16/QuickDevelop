package com.llx.base;

import android.content.Context;

import java.io.File;
import java.util.Collections;
import java.util.List;

import okhttp3.HttpUrl;
import timber.log.Timber;

/**
 * 全局配置环境，
 *
 * 主要封装了初始化常用框架所需要的一些参数，这些参数,不同的module可能会有不同，
 * 但这里会提供一些默认的实现
 *
 */

public class Configuration {

    /**
     * 服务器接口，这个必须要实现
     */
    private HttpUrl baseUrl;

    /**
     * 调试日志输出
     */
    private List<? extends Timber.Tree> debugTrees;

    /**
     * 正式环境日志输出
     */
    private List<? extends Timber.Tree> produceTrees;

    /**
     * RxCache的缓存文件夹
     */
    private File rxCacheDir;

    /**
     * 有的框架初始化需要Context，这里保存一个Context方便以后的使用
     */
    private Context context;


    void setBaseUrl(HttpUrl baseUrl) {
        this.baseUrl = baseUrl;
    }

    void setDebugTrees(List<? extends Timber.Tree> debugTrees) {
        this.debugTrees = debugTrees;
    }

    void setProduceTrees(List<? extends Timber.Tree> produceTrees) {
        this.produceTrees = produceTrees;
    }

    void setRxCacheDir(File cacheDir) {
        this.rxCacheDir = cacheDir;
    }

    void setContext(Context context) {
        this.context = context;
    }

    public HttpUrl getBaseUrl() {
        return baseUrl;
    }

    public List<? extends Timber.Tree> getDebugTrees() {
        return debugTrees;
    }

    public List<? extends Timber.Tree> getProduceTrees() {
        return produceTrees;
    }

    public File getRxCacheDir() {
        return this.rxCacheDir;
    }

    public Context getContext() {
        return this.context;
    }

    private Configuration() {
    }

    public static class Builder {

        private Context mContext;

        private HttpUrl mBaseUrl;
        private List<? extends Timber.Tree> mDebugTrees;
        private List<? extends Timber.Tree> mProduceTrees;
        private File mRxCacheDir;

        Builder(Context context) {
            mContext = context;
        }

        public Builder setBaseUrl(HttpUrl baseUrl) {

            this.mBaseUrl = baseUrl;
            return this;
        }

        public Builder setDebugTrees(List<? extends Timber.Tree> debugTrees) {
            this.mDebugTrees = debugTrees;
            return this;
        }

        public Builder setProduceTrees(List<? extends Timber.Tree> produceTrees) {
            this.mProduceTrees = produceTrees;
            return this;
        }

        public Builder setRxCacheDir(File cacheDir) {
            this.mRxCacheDir = cacheDir;
            return this;
        }

        /**
         * 这里只需要一个全局的Configuration，因此并不需要builder去返回一个实例
         */
        Configuration build() {
            Configuration con =  new Configuration();

            con.setContext(mContext);

            if (mBaseUrl == null) {
                throw new IllegalStateException("you must set base url through IConfigurationInjector.Inject(Configuration.Builder)");
            } else {
                con.setBaseUrl(mBaseUrl);
            }

            if (mDebugTrees == null) {
                con.setDebugTrees(Collections.<Timber.Tree>singletonList(new Timber.DebugTree()));
            } else {
                con.setDebugTrees(mDebugTrees);
            }

            /*if (mProduceTrees == null) {
                con.setProduceTrees(Collections.<Timber.Tree>singletonList(new ErrorLogReportingTree()));
            } else {
                con.setProduceTrees(mProduceTrees);
            }*/

            if (mRxCacheDir == null) {
                con.setRxCacheDir(mContext.getCacheDir());
            } else {
                con.setRxCacheDir(mRxCacheDir);
            }

            return con;

        }
    }
}
