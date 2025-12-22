package com.hcvardar.manne.rkvaradr.ui.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PhotoGallery implements Serializable {
    int id;
    boolean isVideo;
    String nameEvent, headerImageUrl, date, videoId;
    ArrayList<String> images;

    public PhotoGallery(){};

    public PhotoGallery(int id, String nameEvent, String headerImageUrl, String date){
        this.id = id;
        this.nameEvent = nameEvent;
        this.headerImageUrl = headerImageUrl;
        this.date = date;
    }

    public PhotoGallery(String nameEvent, String headerImageUrl, String date, String videoId){
        this.nameEvent = nameEvent;
        this.headerImageUrl = headerImageUrl;
        this.date = date;
        this.videoId = videoId;
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

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }

    public String getVideoId() {
        return videoId;
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
