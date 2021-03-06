package com.example.hdehaan93.schedulerama;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class FrontActivity extends ActionBarActivity {

    private Button mCreateButton;
    private Button mloadButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        mCreateButton=(Button)findViewById(R.id.create_button);
        mloadButton=(Button)findViewById(R.id.load_button);
        mloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start DataActivity
                Intent i = new Intent(FrontActivity.this, LoadActivity.class);
                startActivity(i);
            }
        });
        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start DataActivity
                Intent i = new Intent(FrontActivity.this, DataActivity.class);
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_front, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
