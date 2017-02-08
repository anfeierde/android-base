package com.cz1.rebase_android.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cz1 on 2017/2/8.
 */

public class RetrofitCfg {

    final Api mApi;

    // 设置时间戳统一格式
    final static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-mm-dd'T'HH:mm:ss.SSS'Z'")
            .serializeNulls()
            .create();


    RetrofitCfg(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        if (ApiFactory.isDebug) {
            // 添加日志拦截器
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(logging);
        }

        // 连接超时
        httpClient.connectTimeout(12, TimeUnit.SECONDS);

        OkHttpClient client = httpClient.build();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        mApi = retrofit.create(Api.class);
    }

    public Api getApi() {
        return mApi;
    }


}
