package com.hcvardar.manne.rkvaradr.ui.model;

public class TableResult {
    String name, logo;
    int playedMatches, wonMatches, drawMatches, lostMatches, points;

    public TableResult(){}

    public TableResult(String name, String logo, int playedMatches, int wonMatches, int drawMatches,
                       int lostMatches, int points){
        this.name = name;
        this.logo = logo;
        this.playedMatches = playedMatches;
        this.wonMatches = wonMatches;
        this.drawMatches = drawMatches;
        this.lostMatches = lostMatches;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public int getPlayedMatches() {
        return playedMatches;
    }

    public int getWonMatches() {
        return wonMatches;
    }

    public int getDrawMatches() {
        return drawMatches;
    }

    public int getLostMatches() {
        return lostMatches;
    }

    public int getPoints() {
        return points;
    }
}
