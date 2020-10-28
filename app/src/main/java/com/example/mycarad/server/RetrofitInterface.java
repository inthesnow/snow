package com.example.mycarad.server;

import com.example.mycarad.data.AdvisorBoardDto;
import com.example.mycarad.data.AdvisorReadDto;
import com.example.mycarad.data.AdvisorUserDto;
import com.example.mycarad.data.AdvisorWriteResponse;
import com.example.mycarad.data.DriverBoardDto;
import com.example.mycarad.data.DriverReadDto;
import com.example.mycarad.data.DriverUserDto;
import com.example.mycarad.data.DriverWriteResponse;
import com.example.mycarad.data.LogInResponse;
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
    //로그인
    @Headers("Accept: application/json")
    @POST("/Login.php")
    @FormUrlEncoded
    Observable<LogInResponse> loginRequest(@Field("userID") String id,
                                           @Field("userPassword") String password);

    //드라이버 회원가입_아이디 중복체크
    @Headers("Accept: application/json")
    @POST("/DriverValidate.php")
    @FormUrlEncoded
    Observable<SignUpResponse> checkDriverValidate(@Field("userID") String id);

    //드라이버 회원가입_유저네임 중복체크
    @Headers("Accept: application/json")
    @POST("/DriverNickValidate.php")
    @FormUrlEncoded
    Observable<SignUpResponse> checkDriverNameValidate(@Field("userName") String name);

    //드라이버 회원가입
    @Headers("Accept: application/json")
    @POST("/DriverRegister.php")
    @FormUrlEncoded
    Observable<SignUpResponse> requestSignUpDriver(@Field("userID") String id,
                                                   @Field("userPassword") String pw,
                                                   @Field("userName") String name,
                                                   @Field("carKind") String kind,
                                                   @Field("carName") String carName);

    //광고주 회원가입_아이디 중복체크
    @Headers("Accept: application/json")
    @POST("/AdvisorValidate.php")
    @FormUrlEncoded
    Observable<SignUpResponse> checkAdvisorValidate(@Field("userID") String id);

    //광고주 회원가입_유저네임 중복체크
    @Headers("Accept: application/json")
    @POST("/Adnickvalidate.php")
    @FormUrlEncoded
    Observable<SignUpResponse> checkAdvisorNameValidate(@Field("userName") String name);

    //광고주 회원가입
    @Headers("Accept: application/json")
    @POST("/AdvisorRegister.php")
    @FormUrlEncoded
    Observable<SignUpResponse> requestSignUpAdvisor(@Field("userID") String id,
                                                    @Field("userPassword") String pw,
                                                    @Field("userName") String name,
                                                    @Field("advName") String advName);

    //홈_드라이버 게시글 리스트
    @Headers("Accept: application/json")
    @GET("/DriverBoardList.php")
    Observable<DriverBoardDto> getDriverBoardList();

    //홈_광고주 게시글 리스트
    @Headers("Accept: application/json")
    @GET("/AdvisorBoardList.php")
    Observable<AdvisorBoardDto> getAdvisorBoardList();

    //드라이버 게시글 뷰
    @Headers("Accept: application/json")
    @GET("/ReadDriverBoard.php")
    Observable<DriverReadDto> getDriverRead(@Query("idx") String idx);

    //어드바이저 게시글 뷰
    @Headers("Accept: application/json")
    @GET("/ReadAdvisorBoard.php")
    Observable<AdvisorReadDto> getAdvisorRead(@Query("idx") String idx);


    //드라이버 글쓰기 고정값
    @Headers("Accept: application/json")
    @GET("/ReadDriver.php")
    Observable<DriverUserDto> getDriverWriteResponse(@Query("userName") String userName);

    //어드바이저 글쓰기 고정값
    @Headers("Accept: application/json")
    @GET("/ReadAdvisor.php")
    Observable<AdvisorUserDto> getAdvisorWriteResponse(@Query("userName") String userName);

    //드라이버 글쓰기
    @Headers("Accept: application/json")
    @POST("/DriverWrite.php")
    @FormUrlEncoded
    Observable<DriverWriteResponse> requestWriteDriver(
            @Field("title") String title,
            @Field("userName") String userName,
            @Field("carKind") String carKind,
            @Field("carName") String carName,
            @Field("tuneContent") String tuneContent,
            @Field("connect") String connect,
            @Field("detail") String detail);

    //어드바이저 글쓰기
    @Headers("Accept: application/json")
    @POST("/AdvisorWrite.php")
    @FormUrlEncoded
    Observable<AdvisorWriteResponse> requestWriteAdvisor(
            @Field("title") String title,
            @Field("userName") String userName,
            @Field("advName") String advName,
            @Field("area") String area,
            @Field("carKind") String carKind,
            @Field("connect") String connect,
            @Field("detail") String detail,
            @Field("cost") String cost);
}
