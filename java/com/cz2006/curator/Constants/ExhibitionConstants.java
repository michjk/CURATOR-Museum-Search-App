package com.cz2006.curator.Constants;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * ExhibitionConstants is a class that contains constants related to
 * exhibition crawler class.
 */
public class ExhibitionConstants {
    /**
     * exhibitionUrl contains mapping from museum name to exhibition url.
     * This mapping is used for specifying url of exhibition html page.
     */
    public static HashMap<String, String> exhibitionUrl = new HashMap<>();

    /**
     * exhibitionClass contains mapping from museum name to museum's exhibition
     * crawler class name. This mapping is used for specifying class that need to be
     * loaded by ExhibitionDataFactory class.
     */
    public static HashMap<String, String> exhibitionClass = new HashMap<>();

    /**
     * This function gets data from exhibition.txt to initialize HashMap exhibitionClass
     * (mapping from museum name to museum's exhibition crawler class name) and
     * HashMap exhibitionUrl (mapping from museum name to exhibition url).
     *
     * @param  context  context data of current activity/UI class.
     */
    public static void setExhibitionConstants(Context context) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader( new InputStreamReader(
                    context.getAssets().open("exhibition.txt"), "UTF-8"
            ));

            String line;

            while((line = reader.readLine()) != null) {
                String museumName = line;
                line = reader.readLine();
                String museumClass =  line;
                //line = reader.readLine();
                String url = reader.readLine();

                Log.e("Museum", museumName + museumClass + url);

                exhibitionClass.put(museumName, museumClass);
                exhibitionUrl.put(museumClass, url);

            }
        }catch(IOException e) {
            Log.e("exhibition class", e.getMessage());
        }
        finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e("exhibition class", e.getMessage());
                }
            }
        }
    }
}
