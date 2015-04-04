package com.example.hdehaan93.schedulerama;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hdehaan93 on 3/23/15.
 */
public class ScheduleActivity extends ActionBarActivity{

    public static String BUNDLE_STRING = "GET ME SOME INFO";
    private Bundle mDataBundle;
    private double mNumofTeams;
    private double mNumofGames;
    private TextView mScheduleTextView;
    private RelativeLayout mScheduleLayout;
    private ListView mScheduleListview;
    ArrayAdapter<Games> adp;
    private Event mEvent;
    public static String mGAMES_LIST_STRING ="GAMES_LIST";
    public static String mGAME_NAME_STRING = "WHAT_IS_THE_NAME_OF_THE_GAME";

    /////////////////////////////////////////////////////////////////////////////////////////
    private ArrayList<Games> ScheduleEvent(double teams, double games){
        ArrayList<String> mMatchups = new ArrayList<String>();
        ArrayList<Games> mGameList = new ArrayList<Games>();
        mScheduleTextView.setText("The Schedule is:");
        for(int i=1;i<=teams;i++){

            for(int j=i+1;j<=teams;j++){
                mMatchups.add(i+" vs. " + j);
            }
        }
        for(int i=1;i<= games;i++){
            mGameList.add(new Games("Game "+i));
        }
        //this is the actual logic of how things get scheduled. right now it is just round robin
        for (int i=0;i< mMatchups.size();i++){
            mGameList.get(i%mGameList.size()).AddMatchup(mMatchups.get(i));
        }
        return mGameList;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    private ArrayList<String> PrintEvent(ArrayList<Games> games){
        //print out the games here
        ArrayList<String> s = new ArrayList<String>();
        mScheduleLayout=(RelativeLayout)findViewById(R.id.schedule_layout);
        mScheduleListview=(ListView)findViewById(R.id.schedule_list_view);
        ArrayList<String> mGameNameList= new ArrayList<String >();

        for(int i=0; i<games.size();i++){
            mGameNameList.add(games.get(i).getgGameName());

        }
        adp =new ArrayAdapter<Games>
                (getBaseContext(),R.layout.simple_game_list,games);

        mScheduleListview.setAdapter(adp);



        return s;

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        mScheduleTextView=(TextView)findViewById(R.id.schedule_text_view);
        mDataBundle=getIntent().getBundleExtra(BUNDLE_STRING);
        mNumofTeams=mDataBundle.getDouble(DataActivity.mNUM_TEAMS_STRING);
        mNumofGames=mDataBundle.getDouble(DataActivity.mNUM_GAMES_STRING);

        mEvent= new Event();
        mEvent.setmGames(ScheduleEvent(mNumofTeams, mNumofGames));
        PrintEvent(mEvent.getmGames());
        mScheduleListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //use position and do something?
                mDataBundle.clear();
                //pass it a game and move to next activity
                Games g = (Games)parent.getItemAtPosition(position);
                //mDataBundle.putCharSequenceArrayList(mGAMES_LIST_STRING,g.getgMatchUps());
               // mDataBundle.putStringArray(mGAMES_LIST_STRING,g.getgMatchUps());
                Intent i= new Intent(ScheduleActivity.this, MatchUpActivity.class);
                i.putStringArrayListExtra(mGAMES_LIST_STRING,g.getgMatchUps());
                i.putExtra(mGAME_NAME_STRING, g.getgGameName());
                startActivity(i);

            }
        });







    }


}










/* private RelativeLayout.LayoutParams SetParams(RelativeLayout.LayoutParams p, int gameNum,ArrayList<TextView> v){
        if(gameNum==0){
            p.addRule(RelativeLayout.BELOW, R.id.schedule_text_view);
            p.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            p.addRule(RelativeLayout.ALIGN_PARENT_START);

        }else if(gameNum==1){
            p.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);
            p.removeRule(RelativeLayout.ALIGN_PARENT_START);
            p.addRule(RelativeLayout.BELOW, R.id.schedule_text_view);
            p.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            p.addRule(RelativeLayout.CENTER_IN_PARENT);
            p.addRule(RelativeLayout.ALIGN_RIGHT);
            p.addRule(RelativeLayout.ALIGN_END);


        }else if(gameNum==2){
            p.removeRule(RelativeLayout.CENTER_IN_PARENT);
            p.removeRule(RelativeLayout.ALIGN_RIGHT);
            p.removeRule(RelativeLayout.ALIGN_END);
            p.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            p.addRule(RelativeLayout.BELOW, R.id.schedule_text_view);
            p.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            p.addRule(RelativeLayout.ALIGN_PARENT_END);

        }else if(gameNum%3==0){
            p.addRule(RelativeLayout.BELOW, v.get(gameNum-3).getId());
            p.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            p.removeRule(RelativeLayout.ALIGN_PARENT_END);
            p.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            p.addRule(RelativeLayout.ALIGN_PARENT_START);

        }else if(gameNum%3==1){
            p.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);
            p.removeRule(RelativeLayout.ALIGN_PARENT_START);
            p.addRule(RelativeLayout.BELOW, v.get(gameNum-3).getId());
            p.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            p.addRule(RelativeLayout.CENTER_IN_PARENT);
            p.addRule(RelativeLayout.ALIGN_RIGHT);
            p.addRule(RelativeLayout.ALIGN_END);

        }else if(gameNum%3==2){

        }




        return p;
    }*/



// mScheduleListview.addView();
// RelativeLayout.LayoutParams mParams;// = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
// ArrayList<TextView> mTextViews = new ArrayList<TextView>();
// String AllText=" ";



        /*for(int i=0; i<games.size();i++){
            AllText+="\n"+games.get(i).getgGameName() + "\n";
            for(int j=0;j<games.get(i).getgMatchUps().size();j++){
                AllText+=games.get(i).getgMatchUps().get(j) + " ";
            }
            //this if for the first one
            //put in a loop, if one do this
        // if two do other thing if 3 do other thing 4 or more are all the same
        for(int i=0; i<5;i++){
            TextView x = new TextView(this);
            mParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            mParams=SetParams(mParams,i,mTextViews);
            x.setLayoutParams(mParams);
            x.setText("text for "+ (i+1));
            mScheduleLayout.addView(x);
            x.setId(i);
            mTextViews.add(x);
        }*/