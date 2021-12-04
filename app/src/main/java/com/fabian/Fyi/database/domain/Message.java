package com.fabian.Fyi.database.domain;

public class Message {

    private int id;
    private String tag;
    private String msg;
    private String detail;
    private String dateTime;

    public Message(int id, String tag, String msg, String detail, String dateTime) {
        this.id = id;
        this.tag = tag;
        this.msg = msg;
        this.detail = detail;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
