package com.example.mycarad.data;

import java.util.ArrayList;

public class DriverDummyData {
    static public ArrayList<DriverData> data() {
        DriverData DriverData1 = new DriverData("title1", "time1", "area1", "carkind1");
        DriverData DriverData2 = new DriverData("title2", "time2", "area2", "carkind2");
        DriverData DriverData3 = new DriverData("title3", "time3", "area3", "carkind3");
        DriverData DriverData4 = new DriverData("title4", "time4", "area4", "carkind4");
        DriverData DriverData5 = new DriverData("title5", "time5", "area5", "carkind5");

        ArrayList<DriverData> DriverDataList = new ArrayList<>();
        DriverDataList.add(DriverData1);
        DriverDataList.add(DriverData2);
        DriverDataList.add(DriverData3);
        DriverDataList.add(DriverData4);
        DriverDataList.add(DriverData5);

        return DriverDataList;
    }
}
