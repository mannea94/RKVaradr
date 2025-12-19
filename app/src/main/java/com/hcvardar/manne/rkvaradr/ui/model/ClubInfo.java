package com.hcvardar.manne.rkvaradr.ui.model;

public class ClubInfo {
    String paragraph, imageUrl, year, title;

    public ClubInfo(){}

    public ClubInfo(String paragraph, String imageUrl){
        this.paragraph = paragraph;
        this.imageUrl = imageUrl;
    }

    public ClubInfo(String title, String paragraph, String year){
        this.paragraph = paragraph;
        this.title = title;
        this.year = year;
    }

    public String getParagraph() {
        return paragraph;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }
}
