package com.example.mycarad.data;

public class LogInResponse {
    private Boolean success;
    public Boolean getSuccesss() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    private String userName;
    public  String getUserName() { return userName;}
    public  void setUserName(String userName) {this.userName = userName;}

    private String userType;
    public  String getUserType() { return userType;}
    public void setUserType(String userType) {this.userType = userType;}

    public LogInResponse(Boolean success, String userName, String userType) {
        this.success = success;
        this.userName = userName;
        this.userType = userType;
    }
}
