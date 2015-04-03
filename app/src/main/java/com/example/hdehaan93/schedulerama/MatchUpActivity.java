package com.example.hdehaan93.schedulerama;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

/**
 * Created by hdehaan93 on 3/26/15.
 */
public class MatchUpActivity extends ActionBarActivity {

   private TextView mMatchUps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        mMatchUps=(TextView)findViewById(R.id.match_up_text_view);
        /*mScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show the schedule- next activity
                Intent i= new Intent(DataActivity.this, ScheduleActivity.class);
                mDataBundle.putDouble(mNUM_TEAMS_STRING,mNumofTeams);
                mDataBundle.putDouble(mNUM_GAMES_STRING,mNumofGames);
                i.putExtra(ScheduleActivity.BUNDLE_STRING,mDataBundle);
                startActivity(i);
            }
        });*/


    }

}
