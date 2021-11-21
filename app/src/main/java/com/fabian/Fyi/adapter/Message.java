package com.fabian.Fyi.adapter;

public class Message {

    private String tag;
    private String msg;
    private String detail;

    public Message(String tag, String msg, String detail) {
        this.tag = tag;
        this.msg = msg;
        this.detail = detail;
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
}
