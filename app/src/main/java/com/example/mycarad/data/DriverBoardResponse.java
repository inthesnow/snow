package com.example.mycarad.data;

public class DriverBoardResponse {
    private DriverBoardListResponse response;

    public DriverBoardResponse(DriverBoardListResponse response) {
        this.response = response;
    }

    public DriverBoardListResponse getResponse() {
        return response;
    }

    public void setResponse(DriverBoardListResponse response) {
        this.response = response;
    }
}
