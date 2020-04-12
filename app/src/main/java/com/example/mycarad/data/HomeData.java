package com.example.mycarad.data;

public class HomeData {
    private String title;
    private String time;

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public HomeData(String title, String time) {
        this.title = title;
        this.time = time;
    }
}
