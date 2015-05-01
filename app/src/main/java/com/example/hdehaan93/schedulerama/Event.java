package com.example.hdehaan93.schedulerama;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by hdehaan93 on 3/31/15.
 */
public class Event {

    public Event(String name){
        mGames= new ArrayList<Games>();
        mEventName = name;
        mSerializer = new ScheduleramaJSONSerializer(mAppContext,FILENAME);
    }

    public void setmGames(ArrayList<Games> mGames) {
        this.mGames = mGames;
    }

    public ArrayList<Games> getmGames() {
        return mGames;
    }

    public boolean saveGames(){
        try{
            mSerializer.saveGames(mGames);
            return true;

        } catch( Exception e){

            return false;
        }


    }

    public static Event get( String s) {
        if (sEvent == null) {
            sEvent = new Event(s);
        }
        return sEvent;
    }




    private ArrayList<Games> mGames;
    private String mEventName;

    private static final String TAG = "ScheduleActivity";
    private static final String FILENAME = "event.json";

    private ScheduleramaJSONSerializer mSerializer;
    private static Event sEvent;
    private Context mAppContext;

}
