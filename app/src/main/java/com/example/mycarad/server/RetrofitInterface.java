package com.example.mycarad.server;

import com.example.mycarad.data.DriverBoardListResponse;
import com.example.mycarad.data.SignUpResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @Headers("Accept: application/json")
    @POST("/DriverValidate.php")
    @FormUrlEncoded
    Observable<SignUpResponse> checkDriverValidate(@Field("userID") String id);

    @Headers("Accept: application/json")
    @POST("/DriverNickValidate.php")
    @FormUrlEncoded
    Observable<SignUpResponse> checkDriverNameValidate(@Field("userName") String name);

    @Headers("Accept: application/json")
    @POST("/DriverRegister.php")
    @FormUrlEncoded
    Observable<SignUpResponse> requestSignUpDriver(@Field("userID") String id,
                                                   @Field("userPassword") String pw,
                                                   @Field("userName") String name,
                                                   @Field("carKind") String kind,
                                                   @Field("carName") String carName,
                                                   @Field("carTune") String tune);

    @Headers("Accept: application/json")
    @POST("/DriverValidate.php")
    @FormUrlEncoded
    Observable<SignUpResponse> checkAdvisorValidate(@Field("userID") String id);

    @Headers("Accept: application/json")
    @POST("/DriverValidate.php")
    @FormUrlEncoded
    Observable<SignUpResponse> checkAdvisorNameValidate(@Field("userName") String name);

    @Headers("Accept: application/json")
    @POST("/DriverRegister.php")
    @FormUrlEncoded
    Observable<SignUpResponse> requestSignUpAdvisor(@Field("userID") String id,
                                                   @Field("userPassword") String pw,
                                                   @Field("userName") String name,
                                                   @Field("adKind") String kind,
                                                   @Field("adName") String adName);

    @Headers("Accept: application/json")
    @GET("/BoardList.php")
    Observable<DriverBoardListResponse> getDriverBoardList();
}
