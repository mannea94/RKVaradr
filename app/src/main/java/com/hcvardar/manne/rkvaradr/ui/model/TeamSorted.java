package com.hcvardar.manne.rkvaradr.ui.model;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TeamSorted {
    @SerializedName("Goalkeepers")
    ArrayList<Player> goalkeepers;
    @SerializedName("Backs")
    ArrayList<Player> backs;
    @SerializedName("Picker")
    ArrayList<Player> picker;
    @SerializedName("Wings")
    ArrayList<Player> wings;
    @SerializedName("ExpertStuff")
    ArrayList<Player> expertStuff;
    @SerializedName("Management")
    ArrayList<Player> management;
    public ArrayList<Player> getGoalkeepers() {
        return goalkeepers;
    }

    public ArrayList<Player> getBacks() {
        return backs;
    }

    public ArrayList<Player> getPicker() {
        return picker;
    }

    public ArrayList<Player> getWings() {
        return wings;
    }

    public void setTeamList(JSONArray jsonArray, int playerPosition){
        ArrayList<Player> teamList = new ArrayList<>();
        try {
            Player player;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if(playerPosition==5 || playerPosition==6){
                    player = new Player(
                            obj.getString("name"),
                            obj.getString("imageUrl"),
                            obj.getString("position")
                    );
                }else {
                    player = new Player(
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
                }
                teamList.add(player);
            }
          switch (playerPosition){
              case 1 -> goalkeepers = new ArrayList<>(teamList);
              case 2 -> backs = new ArrayList<>(teamList);
              case 3 -> picker = new ArrayList<>(teamList);
              case 4 -> wings = new ArrayList<>(teamList);
              case 5 -> expertStuff = new ArrayList<>(teamList);
              case 6 -> management = new ArrayList<>(teamList);
          }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Player> getExpertStuff() {
        return expertStuff;
    }

    public void setExpertStuff(ArrayList<Player> expertStuff) {
        this.expertStuff = expertStuff;
    }

    public ArrayList<Player> getManagement() {
        return management;
    }
}
