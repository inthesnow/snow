package com.example.mycarad.server;

import com.example.mycarad.data.SignUpResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @Headers("Accept: application/json")
    @POST("/DriverValidate.php")
    @FormUrlEncoded
    Observable<SignUpResponse> checkDriverValidate(@Field("signDriverIdEditText") String id);

    @Headers("Accept: application/json")
    @POST("/DriverRegister.php")
    @FormUrlEncoded
    Observable<SignUpResponse> requestSignUpDriver(@Field("signDriverIdEditText") String id,
                                                   @Field("signDriverPwEditText") String pw,
                                                   @Field("signDriverNameEditText") String name,
                                                   @Field("signCarKindTextView") String kind,
                                                   @Field("signDriverCarNameEditView") String carName,
                                                   @Field("signDriverBusinessEditText") String tune);


}
