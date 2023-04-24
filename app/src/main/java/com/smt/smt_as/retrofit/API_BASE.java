package com.smt.smt_as.retrofit;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API_BASE {

    Retrofit API_BASE_AS = new Retrofit.Builder()
            .baseUrl("http://211.117.60.119/ars/api2/")
//            .baseUrl("http://61.32.97.141/smt_as/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Retrofit getAPI_BASE_AS() {
        return API_BASE_AS;
    }

    public void setAPI_BASE_AS(Retrofit API_BASE_AS) {
        this.API_BASE_AS = API_BASE_AS;
    }
}
