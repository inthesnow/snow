package com.example.mycarad.server;

import com.example.mycarad.data.AdvisorBoardDto;
import com.example.mycarad.data.AdvisorReadDto;
import com.example.mycarad.data.DriverBoardDto;
import com.example.mycarad.data.SignUpResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
                                                   @Field("carName") String carName);

    @Headers("Accept: application/json")
    @POST("/AdvisorValidate.php")
    @FormUrlEncoded
    Observable<SignUpResponse> checkAdvisorValidate(@Field("userID") String id);

    @Headers("Accept: application/json")
    @POST("/Adnickvalidate.php")
    @FormUrlEncoded
    Observable<SignUpResponse> checkAdvisorNameValidate(@Field("userName") String name);

    @Headers("Accept: application/json")
    @POST("/AdvisorRegister.php")
    @FormUrlEncoded
    Observable<SignUpResponse> requestSignUpAdvisor(@Field("userID") String id,
                                                   @Field("userPassword") String pw,
                                                   @Field("userName") String name,
                                                   @Field("advName") String advName);

    @Headers("Accept: application/json")
    @GET("/BoardList.php")
    Observable<DriverBoardDto> getDriverBoardList();


    @Headers("Accept: application/json")
    @GET("/AdvisorBoardList.php")
    Observable<AdvisorBoardDto> getAdvisorBoardList();


    @Headers("Accept: application/json")
    @GET("/AdvisorRead.php")
    Observable<AdvisorReadDto> getAdvisorRead(@Query("idx") String idx);
}
