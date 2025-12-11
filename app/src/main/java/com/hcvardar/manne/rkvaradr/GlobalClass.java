package com.hcvardar.manne.rkvaradr;

import android.content.Context;

import com.hcvardar.manne.rkvaradr.Model.EkipaModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class GlobalClass {

    public String checkFlag(String countryCode){
        if (countryCode!=null && !countryCode.isEmpty()){
            if(countryCode.equals("MKD"))
                return "https://rkvardar.com.mk/wp-content/uploads/2023/08/tn_mk-flag.gif";
            else if (countryCode.equals("SER"))
                return "https://rkvardar.com.mk/wp-content/uploads/2023/08/tn_ri-flag.gif";
            else if(countryCode.equals("MON"))
                return "https://rkvardar.com.mk/wp-content/uploads/2024/09/Flag_of_Montenegro.svg.png";
            else if(countryCode.equals("SLO"))
                return "https://rkvardar.com.mk/wp-content/uploads/2025/06/Flag-Slovenia.webp";
            else if(countryCode.equals("POL"))
                return "https://rkvardar.com.mk/wp-content/uploads/2025/06/Flag_of_Poland.svg.png";
            else if(countryCode.equals("POR"))
                return "https://rkvardar.com.mk/wp-content/uploads/2023/08/tn_po-flag.gif";
            else if(countryCode.equals("UKR"))
                return "https://rkvardar.com.mk/wp-content/uploads/2024/08/Flag_of_Ukraine.svg.png";
            else if(countryCode.equals("FRA"))
                return "https://rkvardar.com.mk/wp-content/uploads/2025/06/Bandiera_francia_B.jpg";
            else if(countryCode.equals("ARG"))
                return "http://rkvardar.com.mk/wp-content/uploads/2025/06/Flag_of_Argentina.svg.webp";
            else if(countryCode.equals("JAP"))
                return "https://rkvardar.com.mk/wp-content/uploads/2025/08/japan.jpg";
            else return "";
        }else
            return "";
    }
    public ArrayList<EkipaModel> getList(Context context, boolean isEkipa){
        ArrayList<EkipaModel> model = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(readJSONFromAsset(context, isEkipa));
            EkipaModel ekipaModel;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if(isEkipa){
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

    public String readJSONFromAsset(Context context, boolean isEkipa) {
        String json = null;
        try {
            InputStream is = null;
            if(isEkipa)
                is = context.getAssets().open("Ekipa.json");
            else
                is = context.getAssets().open("StrucenStab.json");
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
