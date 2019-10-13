package com.hcvardar.manne.rkvaradr;

import android.content.Context;
import android.content.SharedPreferences;

import com.hcvardar.manne.rkvaradr.Model.EkipaData;
import com.google.gson.Gson;

/**
 * Created by manne on 03.7.2019.
 */

public class PreferencesManager {
    public static void addPlayers(EkipaData user, Context c) {
        Gson gson = new Gson();
        String mapString = gson.toJson(user);
        getPreferences(c).edit().putString("models", mapString).apply();
    }

    public static EkipaData getPlayers(Context c) {
        return new Gson().fromJson(getPreferences(c).getString("models", model), EkipaData.class);
    }

    private static SharedPreferences getPreferences(Context c) {
        return c.getApplicationContext().getSharedPreferences("MySharedPreferences", MainActivity.MODE_PRIVATE);
    }

    public static String model = "{\"models\": [\n" +
            "  {\n" +
            "    \"name\": \"Danis Kristopans\",\n" +
            "    \"birthday\": \"27.09.1990\",\n" +
            "    \"position\": \"Desen beg\",\n" +
            "    \"number\": \"10\",\n" +
            "    \"weight\": \"135kg\",\n" +
            "    \"height\": \"215cm\",\n" +
            "    \"imgurl\": \"https://rkvardar.mk/files/team/2017/09/27/dainis-krishtopans-13981.png\",\n" +
            "    \"imguri\": \"https://rkvardar.mk/files/styles/juicebox_small/public/team/2017/09/27/dainis-krishtopans-13980.png?itok=cSJMzQdr\",\t\n" +
            "  },\n" +
            "{\n" +
            "    \"name\": \"Igor Karacic\",\n" +
            "    \"birthday\": \"02.11.1988\",\n" +
            "    \"position\": \"Sreden beg\",\n" +
            "    \"number\": \"18\",\n" +
            "    \"weight\": \"94kg\",\n" +
            "    \"height\": \"192cm\",\n" +
            "    \"imgurl\": \"https://rkvardar.mk/files/team/2015/02/27/igor-karachikj-13950.png\",\n" +
            "    \"imguri\": \"https://rkvardar.mk/files/styles/juicebox_small/public/team/2015/02/27/igor-karachikj-13949.png?itok=5hwZuVYr\",\t\n" +
            "  },\n" +
            "]}\n";

}
