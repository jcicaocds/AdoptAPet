package com.sample.adoptapet.api;


import com.squareup.moshi.Moshi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class Api {
    private static final String BASE_URL = "http://18.188.125.1:3001";
    private ApiService apiService;

    public Api() {
        apiService = retrofit(BASE_URL, okHttpClient(), moshiConverter(moshi()))
                .create(ApiService.class);
    }

    private OkHttpClient okHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS);
        return builder.build();
    }

    private Moshi moshi() {
        Moshi.Builder builder = new Moshi.Builder();
        return builder.build();
    }

    private MoshiConverterFactory moshiConverter(Moshi moshi) {
        return MoshiConverterFactory.create(moshi);
    }

    private Retrofit retrofit(String baseUrl, OkHttpClient client,
                              MoshiConverterFactory moshiConverter) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(moshiConverter)
                .build();
    }

    public ApiService adoptService() {
        return apiService;
    }
}
