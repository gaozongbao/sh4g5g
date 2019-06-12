package com.c.model;

public class SysLogEntity {
    private Long id;

    private Long userid;

    private String username;

    private String useroperation;

    private String usermethod;

    private String starttime;

    private String endtime;

    private String ipaddress;

    private String params;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseroperation() {
        return useroperation;
    }

    public void setUseroperation(String useroperation) {
        this.useroperation = useroperation;
    }

    public String getUsermethod() {
        return usermethod;
    }

    public void setUsermethod(String usermethod) {
        this.usermethod = usermethod;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "SysLogEntity{" +
                "id=" + id +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", useroperation='" + useroperation + '\'' +
                ", usermethod='" + usermethod + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                ", params='" + params + '\'' +
                '}';
    }
}