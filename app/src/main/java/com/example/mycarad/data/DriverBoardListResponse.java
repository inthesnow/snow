package com.example.mycarad.data;

import java.util.List;

public class DriverBoardListResponse {
    public DriverBoardListResponse(List<DriverBoardData> driverBoardDataList) {
        this.driverBoardDataList = driverBoardDataList;
    }

    private List<DriverBoardData> driverBoardDataList;

    public List<DriverBoardData> getDriverBoardDataList() {
        return driverBoardDataList;
    }

    public void setDriverBoardDataList(List<DriverBoardData> driverBoardDataList) {
        this.driverBoardDataList = driverBoardDataList;
    }
}
