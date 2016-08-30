package com.example.qzl.retrofitdemo.inter;

import com.example.qzl.retrofitdemo.bean.Tngou;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * get请求 ： 是为了获取数据
 * post请求 ： 是为了提交数据
 * Created by Qzl on 2016-08-30.
 */
public interface Service {
    @GET("/")  //参数代表：访问的网址底下的子目录
    Call<String> getBaidu();
    //请求特定值
//    @GET("/api/tngou/list")
//    Call<Tngou> getList(@Query("id") int id, @Query("page") int page, @Query("rows") int rows);

    //category : 分类
    @GET("/api/{category}/list")
    Call<Tngou> getList(@Path("category") String category, @Query("id") int id, @Query("page") int page, @Query("rows") int rows);

    //category : 分类
    @POST("/api/{category}/list")
    @FormUrlEncoded
    Call<Tngou> getPostList(@Path("category") String category, @Field("id") int id, @Field("page") int page, @Field("rows") int rows);
}
