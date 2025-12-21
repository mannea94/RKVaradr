package com.hcvardar.manne.rkvaradr.ui.model;

import java.io.Serializable;

public class Report implements Serializable {
    String matchInfo, pdfUrl;

    public Report(){}

    public Report(String matchInfo, String pdfUrl){
        this.matchInfo = matchInfo;
        this.pdfUrl = pdfUrl;
    }

    public String getMatchInfo() {
        return matchInfo;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }
}
