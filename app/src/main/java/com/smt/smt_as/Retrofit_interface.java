package com.smt.smt_as;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Retrofit_interface {
    //요청

//    @GET("posts/{UserID}")
//    Call<data_model> test_api_get(
//            @Path("UserID") String userid);

    @GET("posts/{Name}")
    Call<data_model> test_api_get(
            @Path("Name") String Name);
}

