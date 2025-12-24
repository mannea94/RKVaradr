package com.hcvardar.manne.rkvaradr;

import android.content.Context;
import android.content.SharedPreferences;

import com.hcvardar.manne.rkvaradr.ui.activity.home.MainActivity;
import com.google.gson.Gson;
import com.hcvardar.manne.rkvaradr.ui.model.EkipaModel;

/**
 * Created by manne on 03.7.2019.
 */

public class PreferencesManager {
    public static void addPlayers(EkipaModel model, Context c) {
        Gson gson = new Gson();
        String mapString = gson.toJson(model);
        getPreferences(c).edit().putString("models", mapString).apply();
    }

    public static EkipaModel getPlayers(Context c) {
        return new Gson().fromJson(getPreferences(c).getString("models", ""), EkipaModel.class);
    }

    private static SharedPreferences getPreferences(Context c) {
        return c.getApplicationContext().getSharedPreferences("MySharedPreferences", MainActivity.MODE_PRIVATE);
    }

}
