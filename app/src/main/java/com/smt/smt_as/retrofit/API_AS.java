package com.smt.smt_as.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API_AS {

    @FormUrlEncoded
    @POST("updateToken.php")
    Call<API_MODEL_UpdateToken> updateToken(@Field("asContents") String contents, @Field("token") String token,
                                            @Field("phone") String phone, @Field("os") String os,
                                            @Field("date") String date); // API 요청 메서드 정의
}
