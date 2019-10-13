package com.hcvardar.manne.rkvaradr.Model;

import java.io.Serializable;

/**
 * Created by manne on 03.7.2019.
 */

public class EkipaModel implements Serializable {
    String name;
    String imgurl;
    String imguri;
    String datum;
    String pozicija;
    String visina;
    String tezina;
    String broj;
    int number;

    public EkipaModel(){

    }

    public EkipaModel(String name, String imgurl){
        this.name=name;
        this.imgurl=imgurl;
    }

    public EkipaModel(String name, String imgurl, String pozicija){
        this.name=name;
        this.imgurl=imgurl;
        this.pozicija=pozicija;
    }

    public EkipaModel(String name, String imageUrl, String imageUrl2, String datum, String pozicija, String tezina, String visina, String broj){
        this.name=name;
        this.imgurl=imageUrl;
        this.imguri=imageUrl2;
        this.datum=datum;
        this.pozicija=pozicija;
        this.visina=visina;
        this.tezina=tezina;
        this.broj=broj;
    }



    public String getIme() {
        return name;
    }

    public String getImageUrl() {
        return imgurl;
    }

    public String getImageUrl2() {
        return imguri;
    }

    public String getDatum() {
        return datum;
    }

    public String getPozicija() {
        return pozicija;
    }

    public String getTezina() {
        return tezina;
    }

    public String getVisina() {
        return visina;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }
}
