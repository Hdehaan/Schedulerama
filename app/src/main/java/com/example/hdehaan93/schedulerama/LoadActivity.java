package com.example.hdehaan93.schedulerama;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by hdehaan93 on 5/1/15.
 */
public class LoadActivity extends ActionBarActivity {

    private Button mBackButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        mBackButton=(Button)findViewById(R.id.backbutton);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start DataActivity
                Intent i = new Intent(LoadActivity.this, FrontActivity.class);
                startActivity(i);
            }
        });
    }


}
