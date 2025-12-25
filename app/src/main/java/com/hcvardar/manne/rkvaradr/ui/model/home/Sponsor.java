package com.hcvardar.manne.rkvaradr.ui.model.home;

public class Sponsor {
    int id;
    String imageUrl;
    String name;
    String webLink;
    public Sponsor(){}

    public Sponsor(int id, String name, String imageUrl, String webLink){
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.webLink = webLink;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getWebLink() {
        return webLink;
    }
}
