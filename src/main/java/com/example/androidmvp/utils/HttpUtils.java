package com.example.androidmvp.utils;

import android.os.Environment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/5/8.
 */

public class HttpUtils {
    private static HttpUtils instance;
    private final Retrofit retrofit;

    private HttpUtils(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        //网络
        okHttpClient.addNetworkInterceptor(httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY));
        okHttpClient.connectTimeout(3000, TimeUnit.SECONDS);//超时
        okHttpClient.readTimeout(3000,TimeUnit.SECONDS);//读取
        File file = new File(Environment.getExternalStorageDirectory(),"cache1111");
        okHttpClient.cache(new Cache(file,10*1024));

        //网址
        retrofit = new Retrofit.Builder()
                .client(okHttpClient.build())
                .baseUrl("https://www.zhaoapi.cn/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    public static  HttpUtils getInstance(){
        if(instance==null){
            synchronized (HttpUtils.class){
                if(null==instance){
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }

}
