package com.example.mycarad.data;

import java.util.ArrayList;

public class DummyData {
   static public ArrayList<HomeData> data() {
        HomeData homeData1 = new HomeData("title1", "time1");
        HomeData homeData2 = new HomeData("title2", "time2");
        HomeData homeData3 = new HomeData("title3", "time3");
        HomeData homeData4 = new HomeData("title4", "time4");
        HomeData homeData5 = new HomeData("title5", "time5");

        ArrayList<HomeData> homeDataList = new ArrayList<>();
        homeDataList.add(homeData1);
        homeDataList.add(homeData2);
        homeDataList.add(homeData3);
        homeDataList.add(homeData4);
        homeDataList.add(homeData5);

        return homeDataList;
    }
}
