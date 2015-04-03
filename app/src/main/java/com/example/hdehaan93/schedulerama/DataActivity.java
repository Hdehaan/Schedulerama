package com.example.hdehaan93.schedulerama;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

/**
 * Created by hdehaan93 on 3/19/15.
 */
public class DataActivity extends ActionBarActivity{

    private NumberPicker mTeamNumPicker;
    private NumberPicker mGameNumPicker;
    private Button mScheduleButton;
    private double mNumofTeams=1;
    private double mNumofGames=1;
    public static String mNUM_TEAMS_STRING ="NUM_OF_TEAMS";
    public static String mNUM_GAMES_STRING ="NUM_OF_GAMES";
    private Bundle mDataBundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        mDataBundle = new Bundle();

        mScheduleButton= (Button)findViewById(R.id.schedule_button);
        mTeamNumPicker=(NumberPicker)findViewById(R.id.team_numberPicker);
        mGameNumPicker=(NumberPicker)findViewById(R.id.game_numberPicker);

        mGameNumPicker.setMaxValue(20);
        mGameNumPicker.setMinValue(1);
        mGameNumPicker.setWrapSelectorWheel(true);
        mTeamNumPicker.setMaxValue(20);
        mTeamNumPicker.setMinValue(1);
        mTeamNumPicker.setWrapSelectorWheel(true);


        mScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show the schedule- next activity
                Intent i= new Intent(DataActivity.this, ScheduleActivity.class);
                mDataBundle.putDouble(mNUM_TEAMS_STRING,mNumofTeams);
                mDataBundle.putDouble(mNUM_GAMES_STRING,mNumofGames);
                i.putExtra(ScheduleActivity.BUNDLE_STRING,mDataBundle);
                startActivity(i);
            }
        });

        mTeamNumPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mTeamNumPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                mNumofTeams=newVal;
            }
        });

        mGameNumPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mGameNumPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                //get the value maybe ?
                mNumofGames=newVal;
            }
        });

    }



}
