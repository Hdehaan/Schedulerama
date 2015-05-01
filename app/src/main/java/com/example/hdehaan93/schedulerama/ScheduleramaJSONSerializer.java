package com.example.hdehaan93.schedulerama;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by hdehaan93 on 4/21/15.
 */
public class ScheduleramaJSONSerializer {
    private Context mContext;
    private String mFilename;
    public ScheduleramaJSONSerializer(Context c, String f){
        mContext = c;
        mFilename = f;


    }

    public void saveGames(ArrayList<Games> games)// save event name somewhere
        throws JSONException, IOException{
            JSONArray array = new JSONArray();
            for( Games g:games){
                array.put(g.toJSON());
            }

            Writer writer = null;
            try{
                OutputStream out = mContext.openFileOutput(mFilename,Context.MODE_PRIVATE);
                writer = new OutputStreamWriter(out);
                writer.write(array.toString());
             } finally {
                if(writer != null){
                    writer.close();
                }
            }
        }
    }
