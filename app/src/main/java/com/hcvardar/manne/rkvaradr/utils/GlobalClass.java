package com.hcvardar.manne.rkvaradr.utils;

import android.content.Context;
import android.content.Intent;

import com.hcvardar.manne.rkvaradr.ui.model.ClubInfo;
import com.hcvardar.manne.rkvaradr.ui.model.Player;
import com.hcvardar.manne.rkvaradr.ui.model.News;
import com.hcvardar.manne.rkvaradr.ui.model.PhotoGallery;
import com.hcvardar.manne.rkvaradr.ui.model.PlayerPosition;
import com.hcvardar.manne.rkvaradr.ui.model.Report;
import com.hcvardar.manne.rkvaradr.ui.model.Result;
import com.hcvardar.manne.rkvaradr.ui.model.Sponsor;
import com.hcvardar.manne.rkvaradr.ui.model.TableResult;
import com.hcvardar.manne.rkvaradr.ui.model.TeamSorted;

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

    public static String checkWebviewTitle(Intent i){
        if (i.hasExtra(Constants.VARDAR_SHOP_EXTRA)) {
            return "Fun Shop";
        }else if (i.hasExtra(Constants.VARDAR_OFFICIAL_EXTRA)) {
            return "РК ВАРДАР";
        }else if (i.hasExtra(Constants.FACEBOOK_EXTRA)) {
            return "Facebook";
        }else if (i.hasExtra(Constants.INSTAGRAM_EXTRA)) {
            return "Instagram";
        }else if (i.hasExtra(Constants.YOUTUBE_EXTRA)) {
            return "YouTube";
        }else if (i.hasExtra(Constants.TICKETS_MK_EXTRA)) {
            return "Tickets MK";
        }else if (i.hasExtra(Constants.VIBER)) {
            return "Viber";
        }else if (i.hasExtra(Constants.VARDAR_CONTACT_EXTRA)) {
            return "Контакт";
        }else if (i.hasExtra(Constants.TICKETS_PLUS_EXTRA)) {
            return "Tickets Plus";
        }else if (i.hasExtra(Constants.LEAGUE_EHF_EXTRA)) {
            return "EHF";
        }else if (i.hasExtra(Constants.LEAGUE_EHF_PLUS_EXTRA)) {
            return "EHF";
        }else if (i.hasExtra(Constants.LEAGUE_EHF_TV_EXTRA)) {
            return "EHF TV";
        }else if(i.hasExtra(Constants.SPONSOR_EXTRA)) {
            return "Спонзори";
        }else if(i.hasExtra("results")){
            return "Резултати";
        }else if(i.hasExtra("sostavi")){
            return "Поранешни состави";
        }
            return "";
    }


    public ArrayList<Player> getList(Context context, int type){
        /*
        0 -> ekipa
        1 -> strucen stab
        2 -> sponzori
        * */
        ArrayList<Player> model = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(readJSONFromAsset(context, type));
            Player player;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if(type==0){
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
                }else {
                    player = new Player(
                            obj.getString("name"),
                            obj.getString("imageUrl"),
                            obj.getString("position")
                    );
                }
                model.add(player);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return model;
    }

    public ArrayList<PlayerPosition> getSortedList(Context context, int type){
        /*Player position
        1 - goalkeeper
        2 - back
        3 - picker
        4 - wing
        * */
        TeamSorted teamSorted = new TeamSorted();
        ArrayList<PlayerPosition> playerPositions = new ArrayList<>();
        PlayerPosition playerPosition = new PlayerPosition();
        playerPositions.add(playerPosition);
        try {
            JSONObject jsonObject = new JSONObject(readJSONFromAsset(context, type));
            if(jsonObject.has("Goalkeepers")){
                teamSorted.setTeamList(jsonObject.getJSONArray("Goalkeepers"), 1);
                playerPosition = new PlayerPosition();
                playerPosition.setPosition("Goalkeepers");
                playerPosition.setPlayers(teamSorted.getGoalkeepers());
                playerPositions.add(playerPosition);
            }
            if(jsonObject.has("Backs")){
                teamSorted.setTeamList(jsonObject.getJSONArray("Backs"), 2);
                playerPosition = new PlayerPosition();
                playerPosition.setPosition("Backs");
                playerPosition.setPlayers(teamSorted.getBacks());
                playerPositions.add(playerPosition);
            }
            if(jsonObject.has("Picker")){
                teamSorted.setTeamList(jsonObject.getJSONArray("Picker"), 3);
                playerPosition = new PlayerPosition();
                playerPosition.setPosition("Picker");
                playerPosition.setPlayers(teamSorted.getPicker());
                playerPositions.add(playerPosition);
            }
            if(jsonObject.has("Wings")){
                teamSorted.setTeamList(jsonObject.getJSONArray("Wings"), 4);
                playerPosition = new PlayerPosition();
                playerPosition.setPosition("Wings");
                playerPosition.setPlayers(teamSorted.getWings());
                playerPositions.add(playerPosition);
            }
            if(jsonObject.has("ExpertStuff")){
                teamSorted.setTeamList(jsonObject.getJSONArray("ExpertStuff"), 5);
                playerPosition = new PlayerPosition();
                playerPosition.setPosition("ExpertStuff");
                playerPosition.setPlayers(teamSorted.getExpertStuff());
                playerPositions.add(playerPosition);
            }
            if(jsonObject.has("Management")){
                teamSorted.setTeamList(jsonObject.getJSONArray("Management"), 6);
                playerPosition = new PlayerPosition();
                playerPosition.setPosition("Management");
                playerPosition.setPlayers(teamSorted.getManagement());
                playerPositions.add(playerPosition);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return playerPositions;
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

    public ArrayList<PhotoGallery> getListPhotoGallery(Context context, int type){
        ArrayList<PhotoGallery> photoGalleries = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(readJSONFromAsset(context, type));
            PhotoGallery photoGallery;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if(type==4){
                    photoGallery = new PhotoGallery(
                            obj.getInt("id"),
                            obj.getString("nameEvent"),
                            obj.getString("headerImageUrl"),
                            obj.getString("date")
                    );
                    photoGallery.setImages(obj.getJSONArray("images"));
                    photoGalleries.add(photoGallery);
                }else {
                    photoGallery = new PhotoGallery(
                            obj.getString("nameEvent"),
                            obj.getString("headerImageUrl"),
                            obj.getString("date"),
                            obj.getString("videoId")
                    );
                    photoGallery.setVideo(true);
                    photoGalleries.add(photoGallery);
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return photoGalleries;
    }

    public ArrayList<TableResult> getListTableResults(Context context, int type){
        ArrayList<TableResult> superLeagues = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(readJSONFromAsset(context, type));
            TableResult superLiga;
            superLeagues.add(new TableResult());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                superLiga = new TableResult(
                        obj.getString("name"),
                        obj.getString("logo"),
                        obj.getInt("playedMatches"),
                        obj.getInt("wonMatches"),
                        obj.getInt("drawMatches"),
                        obj.getInt("lostMatches"),
                        obj.getInt("points")
                );
                superLeagues.add(superLiga);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return superLeagues;
    }

    public ArrayList<ClubInfo> getListClubInfo(Context context, int type){
        ArrayList<ClubInfo> clubInfos = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(readJSONFromAsset(context, type));
            ClubInfo clubInfo;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if(type == 8){
                    clubInfo = new ClubInfo(
                            obj.getString("paragraph"),
                            obj.getString("imageUrl")
                    );
                }else {
                    clubInfo = new ClubInfo(
                            obj.getString("title"),
                            obj.getString("paragraph"),
                            obj.getString("year")
                    );
                }
                clubInfos.add(clubInfo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return clubInfos;
    }

    public ArrayList<News> getListNews(Context context, int type){
        ArrayList<News> listNews = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(readJSONFromAsset(context, type));
            News news;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                news = new News(
                        obj.getString("title"),
                        obj.getString("headerImage"),
                        obj.getString("paragraph"),
                        obj.getString("date")
                );
                if(obj.has("Report")){
                    Report report = new Report(
                            obj.getJSONObject("Report").getString("matchInfo"),
                            obj.getJSONObject("Report").getString("pdfUrl")
                    );
                    news.setReport(report);
                }
                listNews.add(news);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listNews;
    }

    public String readJSONFromAsset(Context context, int type) {
        String json = null;
        try {
            InputStream is = null;
            switch (type){
                case 0 -> is = context.getAssets().open("Team.json");
                case 1 -> is = context.getAssets().open("StrucenStab.json");
                case 2 -> is = context.getAssets().open("Sponsors.json");
                case 3 -> is = context.getAssets().open("Results.json");
                case 4 -> is = context.getAssets().open("PhotoGallery.json");
                case 5 -> is = context.getAssets().open("SuperLiga.json");
                case 6 -> is = context.getAssets().open("PlayOff.json");
                case 7 -> is = context.getAssets().open("EuropeanLeague.json");
                case 8 -> is = context.getAssets().open("ClubInfo.json");
                case 9 -> is = context.getAssets().open("ClubHistory.json");
                case 10 -> is = context.getAssets().open("News.json");
                case 11 -> is = context.getAssets().open("VideoGallery.json");
                case 12 -> is = context.getAssets().open("TeamSorted.json");
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
