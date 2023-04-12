package com.smt.smt_as;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit_client {
    private static final String BASE_URL = "61.32.97.141/SMT_AS/insert.php";
//    http://61.32.97.141/cubeCalendar/index.php


    public static Retrofit_interface getApiService(){
        return getInstance().create(Retrofit_interface.class);
    }

    private static Retrofit getInstance(){
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
