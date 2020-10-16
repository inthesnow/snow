package com.example.mycarad.server;

import com.android.volley.AuthFailureError;

import com.android.volley.Response;

import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.StringRequest;

import java.net.HttpURLConnection;
import java.util.HashMap;

import java.util.Map;

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://felixlsh.dothome.co.kr/UserRegister.php";

    private Map<String, String> parameters;

    public RegisterRequest(String userID, String userPassword, String userName, String carKind, String carName, String tuningInfo, Response.Listener<String> listener){

        super(Method.POST, URL, listener, null);//해당 URL에 POST방식으로 파마미터들을 전송함

        parameters = new HashMap<>();

        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("userName", userName);
        parameters.put("carKind", carKind);
        parameters.put("carName", carName);
        parameters.put("tuningInfo", tuningInfo);
    }

    @Override

    protected Map<String, String> getParams() throws AuthFailureError {

        return parameters;

    }

}