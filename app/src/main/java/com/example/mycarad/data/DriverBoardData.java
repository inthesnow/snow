package com.example.mycarad.data;

public class DriverBoardData {
    private String idx;
    private String userName;
    private String title;
    private String userPassword;
    private String content;
    private String date;

    public DriverBoardData(String idx, String userName, String title,String userPassword, String content, String date) {
        this.idx = idx;
        this.userName = userName;
        this.title = title;
        this.userPassword = userPassword;
        this.content = content;
        this.date = date;
    }

    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
