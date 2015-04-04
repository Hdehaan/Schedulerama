package com.example.hdehaan93.schedulerama;

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

    private ArrayList<String> gMatchUps;
    private String gGameName;
    private UUID mID;
}
