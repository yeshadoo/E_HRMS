package com.dmu.hrms.entity;

public class ChangePost {
    private Integer id;

    private Integer staffId;

    private String sname;

    private String currentPost;

    private String targetPost;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCurrentPost() {
        return currentPost;
    }

    public void setCurrentPost(String currentPost) {
        this.currentPost = currentPost;
    }

    public String getTargetPost() {
        return targetPost;
    }

    public void setTargetPost(String targetPost) {
        this.targetPost = targetPost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}