package com.hcvardar.manne.rkvaradr;

import android.content.Context;

import com.hcvardar.manne.rkvaradr.Model.EkipaModel;
import com.hcvardar.manne.rkvaradr.Model.Result;
import com.hcvardar.manne.rkvaradr.Model.Sponsor;
import com.hcvardar.manne.rkvaradr.utils.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class GlobalClass {

    public String checkFlag(String countryCode){
        if (countryCode!=null && !countryCode.isEmpty()){
            return switch (countryCode) {
                case "MKD" -> Constants.VARDAR_UPLOADS_URL.concat("2023/08/tn_mk-flag.gif");
                case "SER" -> Constants.VARDAR_UPLOADS_URL.concat("2023/08/tn_ri-flag.gif");
                case "MON" -> Constants.VARDAR_UPLOADS_URL.concat("2024/09/Flag_of_Montenegro.svg.png");
                case "SLO" -> Constants.VARDAR_UPLOADS_URL.concat("2025/06/Flag-Slovenia.webp");
                case "POL" -> Constants.VARDAR_UPLOADS_URL.concat("2025/06/Flag_of_Poland.svg.png");
                case "POR" -> Constants.VARDAR_UPLOADS_URL.concat("2023/08/tn_po-flag.gif");
                case "UKR" -> Constants.VARDAR_UPLOADS_URL.concat("2024/08/Flag_of_Ukraine.svg.png");
                case "FRA" -> Constants.VARDAR_UPLOADS_URL.concat("2025/06/Bandiera_francia_B.jpg");
                case "ARG" -> Constants.VARDAR_UPLOADS_URL.concat("2025/06/Flag_of_Argentina.svg.webp");
                case "JAP" -> Constants.VARDAR_UPLOADS_URL.concat("2025/08/japan.jpg");
                default -> "";
            };
        }else
            return "";
    }
    public ArrayList<EkipaModel> getList(Context context, int type){
        /*
        0 -> ekipa
        1 -> strucen stab
        2 -> sponzori
        * */
        ArrayList<EkipaModel> model = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(readJSONFromAsset(context, type));
            EkipaModel ekipaModel;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if(type==0){
                    ekipaModel = new EkipaModel(
                        obj.getString("name"),
                        obj.getString("imageUrl"),
                        obj.getString("imageUrl"),
                        obj.getString("dateOfBirth"),
                        obj.getString("position"),
                        obj.getString("weight"),
                        obj.getString("height"),
                        obj.getString("playerNumber"),
                        obj.getString("nationality")
                );
                }else {
                    ekipaModel = new EkipaModel(
                            obj.getString("name"),
                            obj.getString("imageUrl"),
                            obj.getString("position")
                    );
                }
                model.add(ekipaModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return model;
    }

    public ArrayList<Sponsor> getListSponsors(Context context, int type){
        ArrayList<Sponsor> sponsors = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(readJSONFromAsset(context, type));
            Sponsor sponsor;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                sponsor = new Sponsor(
                        obj.getInt("id"),
                        obj.getString("name"),
                        obj.getString("imageUrl"),
                        obj.getString("webLink")
                );
                sponsors.add(sponsor);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sponsors;
    }

    public ArrayList<Result> getListResults(Context context, int type){
        ArrayList<Result> results = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(readJSONFromAsset(context, type));
            Result result;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                result = new Result(
                        obj.getString("hostName"),
                        obj.getString("hostLogo"),
                        obj.getInt("hostResult"),
                        obj.getString("guestName"),
                        obj.getString("guestLogo"),
                        obj.getInt("guestResult"),
                        obj.getString("date")
                );
                results.add(result);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return results;
    }
    public String readJSONFromAsset(Context context, int type) {
        String json = null;
        try {
            InputStream is = null;
            switch (type){
                case 0 -> is = context.getAssets().open("Ekipa.json");
                case 1 -> is = context.getAssets().open("StrucenStab.json");
                case 2 -> is = context.getAssets().open("Sponsors.json");
                case 3 -> is = context.getAssets().open("Results.json");
            }
            assert is != null;
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
