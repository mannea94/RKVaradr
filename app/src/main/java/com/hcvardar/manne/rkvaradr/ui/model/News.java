package com.hcvardar.manne.rkvaradr.ui.model;

import java.io.Serializable;

public class News implements Serializable {
    String title, headerImage, paragraph, date;

    public Report report;
    public News(){}

    public News(String title, String headerImage, String paragraph, String date){
        this.title = title;
        this.headerImage = headerImage;
        this.paragraph = paragraph;
        this. date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public String getParagraph() {
        return paragraph;
    }

    public String getDate() {
        return date;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Report getReport() {
        return report;
    }
}
