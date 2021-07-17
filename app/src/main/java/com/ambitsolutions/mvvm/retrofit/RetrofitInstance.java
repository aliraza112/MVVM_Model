package com.ambitsolutions.mvvm.retrofit;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static final Retrofit retrofit = null;

    public static Retrofit getClient(Context context) {

        SharedPreferences read_preferences = context.getSharedPreferences("MySharedPref", Activity.MODE_PRIVATE);

        String token1 = read_preferences.getString("token", "");
       // String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0aW1lU3RhbXAiOiIyMDIxLTAzLTE2IDA3OjIzOjA0In0.bFL-GrJD-u_Y5qv3GuRKCE8nwxj-m1m47Ga98pPfVBM";

        String BASE_URL = "http://uogsmartload.net/paklivestock/api/";

        // Base Url + Relative Url make complete api to get data
        // String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0aW1lU3RhbXAiOiIyMDIxLTAzLTE2IDA3OjIzOjA0In0.bFL-GrJD-u_Y5qv3GuRKCE8nwxj-m1m47Ga98pPfVBM";

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
              .retryOnConnectionFailure(true)
                .addInterceptor(loggingInterceptor
                        .setLevel(HttpLoggingInterceptor.Level.BODY)).build();

        Retrofit retrofit = new Retrofit.Builder() //build url
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;

    }

}

