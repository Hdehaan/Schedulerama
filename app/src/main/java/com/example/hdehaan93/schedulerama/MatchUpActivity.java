package com.example.hdehaan93.schedulerama;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hdehaan93 on 3/26/15.
 */
public class MatchUpActivity extends ActionBarActivity {

   private TextView mMatchUp_textView;
    public ArrayList<String> mMatchUps= new ArrayList<String>();
    public String mGameName;
    private TextView mGameName_textView;

    void Print_MatchUps(ArrayList<String> g, String name){

        mGameName_textView.setText(name);
        String AllText="";
            for(int j=0;j<g.size();j++){
                AllText+=g.get(j) + "\n";
            }
        mMatchUp_textView.setText(AllText);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matchup);

        mMatchUp_textView=(TextView)findViewById(R.id.match_up_text_view);
        mGameName_textView=(TextView)findViewById(R.id.textView_game);
        mMatchUps=getIntent().getStringArrayListExtra(ScheduleActivity.mGAMES_LIST_STRING);
        mGameName=getIntent().getStringExtra(ScheduleActivity.mGAME_NAME_STRING);
        Print_MatchUps(mMatchUps,mGameName);

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
