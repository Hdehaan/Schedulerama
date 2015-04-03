package com.example.hdehaan93.schedulerama;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by hdehaan93 on 3/31/15.
 */
public class Event {

    public Event(){
        mGames= new ArrayList<Games>();
    }

    public void setmGames(ArrayList<Games> mGames) {
        this.mGames = mGames;
    }

    public ArrayList<Games> getmGames() {
        return mGames;
    }




    private ArrayList<Games> mGames;

}
