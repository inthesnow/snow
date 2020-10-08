package com.example.mycarad.data;

import java.util.ArrayList;

public class CaruserDummyData {
    static public ArrayList<CaruserData> data() {
        CaruserData CaruserData1 = new CaruserData("title1", "time1", "area1", "carkind1");
        CaruserData CaruserData2 = new CaruserData("title2", "time2", "area2", "carkind2");
        CaruserData CaruserData3 = new CaruserData("title3", "time3", "area3", "carkind3");
        CaruserData CaruserData4 = new CaruserData("title4", "time4", "area4", "carkind4");
        CaruserData CaruserData5 = new CaruserData("title5", "time5", "area5", "carkind5");

        ArrayList<CaruserData> CaruserDataList = new ArrayList<>();
        CaruserDataList.add(CaruserData1);
        CaruserDataList.add(CaruserData2);
        CaruserDataList.add(CaruserData3);
        CaruserDataList.add(CaruserData4);
        CaruserDataList.add(CaruserData5);

        return CaruserDataList;
    }
}
