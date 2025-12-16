package com.hcvardar.manne.rkvaradr.ui.model;

public class Result {
    int id;
    String hostName;
    String hostLogo;
    int hostResult;
    String guestName;
    String guestLogo;
    int guestResult;
    String date;

    public Result(){}

    public Result(String hostName, String hostLogo, int hostResult,
                  String guestName, String guestLogo, int guestResult, String date){
        this.hostName = hostName;
        this.hostLogo = hostLogo;
        this.hostResult = hostResult;
        this.guestName = guestName;
        this.guestLogo = guestLogo;
        this.guestResult = guestResult;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getHostName() {
        return hostName;
    }

    public String getHostLogo() {
        return hostLogo;
    }

    public int getHostResult() {
        return hostResult;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getGuestLogo() {
        return guestLogo;
    }

    public int getGuestResult() {
        return guestResult;
    }

    public String getDate() {
        return date;
    }
}
