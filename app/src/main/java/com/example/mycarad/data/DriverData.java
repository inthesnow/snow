package com.example.mycarad.data;

public class DriverData {
    private String title;
    private String time;
    private String area;
    private String carKind;

    public String getTitle() {
        return title;
    }
    public String getTime() {
        return time;
    }
    public String getArea() { return area; }
    public String getCarKind() { return carKind; }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public void setCarKind(String carKind) {
        this.carKind = carKind;
    }

    public DriverData(String title, String time, String area, String carKind) {
        this.title = title;
        this.time = time;
        this.area = area;
        this.carKind = carKind;
    }
}
