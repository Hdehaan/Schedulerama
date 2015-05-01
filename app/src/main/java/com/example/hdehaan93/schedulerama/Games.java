package com.example.hdehaan93.schedulerama;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by hdehaan93 on 3/24/15.
 */
public class Games{
    Games(String name){
        gMatchUps = new ArrayList<String>();
        gGameName= name;
        mID= UUID.randomUUID();
    }
    public void AddMatchup(String s){
        gMatchUps.add(s);
    }

    public UUID getID(){
        return mID;
    }

    public String getgGameName() {
        return gGameName;
    }

    public ArrayList<String> getgMatchUps() {
        return gMatchUps;
    }
    @Override
    public String toString(){
       return gGameName;
    }

    public JSONObject toJSON () throws JSONException{
        JSONObject json = new JSONObject();
        json.put(JSON_GAMENAME,gGameName);
        json.put(JSON_MATCHUPS,gMatchUps);
        return json;
    }


    private ArrayList<String> gMatchUps;
    private String gGameName;
    private UUID mID;
    private static final String JSON_GAMENAME = "GameName";
    private static final String JSON_MATCHUPS = "Matchups";



}
