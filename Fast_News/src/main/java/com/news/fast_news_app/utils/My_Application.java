package com.news.fast_news_app.utils;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

import cn.sharesdk.framework.ShareSDK;
import cn.smssdk.SMSSDK;

/**
 * Created by Administrator on 2016/2/29.
 */
public class My_Application extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ShareSDK.initSDK(this);
        SMSSDK.initSDK(this, "101499bef6a4c", "7c2d9bc7c4f1c64a46d092ca87bc9453");
        File catchDir = StorageUtils.getOwnCacheDirectory(getApplicationContext(),"imageloader/Cache");
        //创建默认的ImageLoader配置参数
        ImageLoaderConfiguration configuration =new ImageLoaderConfiguration.Builder(getApplicationContext()).diskCache(new UnlimitedDiskCache(catchDir)).build();
        //Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(configuration);
    }
}
