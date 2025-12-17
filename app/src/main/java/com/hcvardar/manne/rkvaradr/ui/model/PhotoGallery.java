package com.hcvardar.manne.rkvaradr.ui.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PhotoGallery implements Serializable {
    int id;
    String nameEvent, headerImageUrl, date;
    ArrayList<String> images;

    public PhotoGallery(){};

    public PhotoGallery(int id, String nameEvent, String headerImageUrl, String date){
        this.id = id;
        this.nameEvent = nameEvent;
        this.headerImageUrl = headerImageUrl;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public String getHeaderImageUrl() {
        return headerImageUrl;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(JSONArray jsonArray){
        images = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                images.add(jsonArray.getString(i));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
