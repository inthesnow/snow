package com.example.mycarad.data;

public class AdvisorData {
    private String title;
    private String time;
    private String area;
    private String money;

    public String getTitle() {
        return title;
    }
    public String getTime() {
        return time;
    }
    public String getArea() { return area; }
    public String getMoney() { return money; }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public void setMoney(String money) {
        this.money = money;
    }

    public AdvisorData(String title, String time, String area, String money) {
        this.title = title;
        this.time = time;
        this.area = area;
        this.money = money;
    }
}
