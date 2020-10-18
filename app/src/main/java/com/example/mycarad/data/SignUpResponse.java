package com.example.mycarad.data;

public class SignUpResponse {
    private Boolean success;

    public Boolean getSuccesss() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public SignUpResponse(Boolean success) {
        this.success = success;
    }
}
