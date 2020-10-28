package com.example.mycarad.data;

public class LogInResponse {
    private Boolean success;

    public Boolean getSuccesss() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public LogInResponse(Boolean success) {
        this.success = success;
    }
}
