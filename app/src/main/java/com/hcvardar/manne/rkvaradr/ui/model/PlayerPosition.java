package com.hcvardar.manne.rkvaradr.ui.model;

import java.util.ArrayList;

public class PlayerPosition {
    String position;
    ArrayList<Player> players;



    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
