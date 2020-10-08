package com.example.mycarad.data;

import java.util.ArrayList;

public class AdvisorDummyData {
    static public ArrayList<AdvisorData> data() {
        AdvisorData AdvisorData1 = new AdvisorData("title1", "time1", "area1", "money1");
        AdvisorData AdvisorData2 = new AdvisorData("title2", "time2", "area2", "money2");
        AdvisorData AdvisorData3 = new AdvisorData("title3", "time3", "area3", "money3");
        AdvisorData AdvisorData4 = new AdvisorData("title4", "time4", "area4", "money4");
        AdvisorData AdvisorData5 = new AdvisorData("title5", "time5", "area5", "money5");
        AdvisorData AdvisorData6 = new AdvisorData("title6", "time1", "area1", "money1");
        AdvisorData AdvisorData7 = new AdvisorData("title2", "time2", "area2", "money2");
        AdvisorData AdvisorData8 = new AdvisorData("title3", "time3", "area3", "money3");
        AdvisorData AdvisorData9 = new AdvisorData("title4", "time4", "area4", "money4");
        AdvisorData AdvisorData10 = new AdvisorData("title5", "time5", "area5", "money5");

        ArrayList<AdvisorData> AdvisorDataList = new ArrayList<>();
        AdvisorDataList.add(AdvisorData1);
        AdvisorDataList.add(AdvisorData2);
        AdvisorDataList.add(AdvisorData3);
        AdvisorDataList.add(AdvisorData4);
        AdvisorDataList.add(AdvisorData5);
        AdvisorDataList.add(AdvisorData6);
        AdvisorDataList.add(AdvisorData7);
        AdvisorDataList.add(AdvisorData8);
        AdvisorDataList.add(AdvisorData9);
        AdvisorDataList.add(AdvisorData10);
        return AdvisorDataList;
    }
}
