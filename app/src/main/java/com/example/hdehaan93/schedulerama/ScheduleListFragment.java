package com.example.hdehaan93.schedulerama;

import android.app.ListFragment;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by hdehaan93 on 3/31/15.
 */
public class ScheduleListFragment extends ListFragment {
    private ArrayList<Games> mGames;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.title);
        //mGames =
    }
}
