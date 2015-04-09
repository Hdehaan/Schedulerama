package com.example.hdehaan93.schedulerama;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hdehaan93 on 4/7/15.
 */

/**
 * This Activity will create multiple text fields for the
 * user to input the names of the games and teams
 * TODO: add textviews to xml that say name of game and name of team
 * TODO: get bundle and unpack it.
 * TODO: create appropriate numbers of text fields for input
 * TODO: pack them up in an array list
 * TODO: send all to ScheduleActivity
 * **/

public class NamingActivity extends ActionBarActivity {

    public static String BUNDLE_STRING = "GET ME SOME INFO";
    public static String GAMES_STRING = "GET THE GAME NAMES";
    public static String TEAM_STRING = " GET THE TEAM NAMES";
    private Bundle mDataBundle;
    private double mNumofTeams;
    private double mNumofGames;
    public TableLayout mTableLayout;
   // public Event mEvent;
    public ArrayList<String> mGameNames;
    public ArrayList<String> mTeamNames;
    public ArrayList<TableRow> mTableRows;
    public ArrayList<EditText> mTeamEditTexts;
    public ArrayList<EditText> mGameEditTexts;
    public Button mNextButton;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naming);

        mDataBundle=getIntent().getBundleExtra(BUNDLE_STRING);
        mNumofTeams=mDataBundle.getDouble(DataActivity.mNUM_TEAMS_STRING);
        mNumofGames=mDataBundle.getDouble(DataActivity.mNUM_GAMES_STRING);
        mTableLayout=(TableLayout)findViewById(R.id.naming_tablelayout);


        mTableRows = new ArrayList<TableRow>() ;
        mTeamEditTexts= new ArrayList<EditText>();
        mGameEditTexts= new  ArrayList<EditText>();

        for(int i=0;i<Math.max(mNumofGames,mNumofTeams);i++){
            mTableRows.add(new TableRow(NamingActivity.this)); // add as many rows as we need

        }
        for(int i=0; i<Math.max(mNumofGames,mNumofTeams); i++){
            if(i<mNumofTeams){
                mTeamEditTexts.add(new EditText(NamingActivity.this));
                mTeamEditTexts.get(i).setHint("Edit team name "+ (i+1));
                mTableRows.get(i).addView(mTeamEditTexts.get(i));
            }
            else{
                mTableRows.get(i).addView(new TextView(NamingActivity.this));// not good, fix this. very cheap
            }
            if(i<mNumofGames){
                mGameEditTexts.add(new EditText(NamingActivity.this));// if an edit text is needed, add it
                mGameEditTexts.get(i).setHint("Edit Game name " + (i + 1));
               // mGameEditTexts.get(i).setRight(300);
                mTableRows.get(i).addView(mGameEditTexts.get(i));
            }
        }

        for(int i =0; i< mTableRows.size();i++){
            mTableLayout.addView(mTableRows.get(i));
        }
        mNextButton= new Button(NamingActivity.this);
        mNextButton.setText("Schedule!");
        //mNextButton.setWidth(300);
        mNextButton.setBackgroundColor(Color.RED);
        mTableLayout.addView(mNextButton);
        setContentView(mTableLayout);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGameNames = new ArrayList<String>();
                mTeamNames = new ArrayList<String>();
                for(int i =0; i< mNumofTeams;i++){
                    mTeamNames.add(mTeamEditTexts.get(i).getText().toString());
                }

                for(int i =0; i< mNumofGames;i++){
                    mGameNames.add(mGameEditTexts.get(i).getText().toString());
                }
                // show the schedule- next activity
                Intent i= new Intent(NamingActivity.this, ScheduleActivity.class);
                mDataBundle.putDouble(DataActivity.mNUM_TEAMS_STRING,mNumofTeams);
                mDataBundle.putDouble(DataActivity.mNUM_GAMES_STRING,mNumofGames);
                i.putExtra(ScheduleActivity.BUNDLE_STRING,mDataBundle);
                i.putStringArrayListExtra(GAMES_STRING,mGameNames);
                i.putStringArrayListExtra(TEAM_STRING,mTeamNames);

                startActivity(i);


            }
        });





       // mEvent= new Event();




    }
}
