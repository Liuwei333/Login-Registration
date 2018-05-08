package com.example.androidmvp.utils;

import com.example.androidmvp.bean.DengBean;
import com.example.androidmvp.bean.ZhuBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/5/8.
 */

public interface Api {

    @GET("login")
    Observable<DengBean>doGet(@Query("mobile")String mobile,@Query("password")String password);

    @GET("reg")
    Observable<ZhuBean>doZhu(@Query("mobile")String mobile, @Query("password")String password);
}
