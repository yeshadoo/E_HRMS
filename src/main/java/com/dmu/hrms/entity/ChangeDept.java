package com.dmu.hrms.entity;

public class ChangeDept {
    private Integer id;

    private Integer staffId;

    private String sname;

    private String currentDept;

    private String targerDept;

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

    public String getCurrentDept() {
        return currentDept;
    }

    public void setCurrentDept(String currentDept) {
        this.currentDept = currentDept;
    }

    public String getTargerDept() {
        return targerDept;
    }

    public void setTargerDept(String targerDept) {
        this.targerDept = targerDept;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}