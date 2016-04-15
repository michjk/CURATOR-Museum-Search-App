package com.cz2006.curator.Constants;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Acceleration on 18/03/2016.
 */
public class ExhibitionConstants {
    public static HashMap<String, String> exhibitionUrl = new HashMap<String, String>() /*{
        {
            put("Art Science Museum","http://www.marinabaysands.com/museum/exhibitions-and-events.html");
            put("National Museum of Singapore", "http://nationalmuseum.sg/exhibitions/exhibition-list");
            put("Singapore Art Museum", "https://www.singaporeartmuseum.sg/exhibitions/current.html");
            put("National Gallery Singapore", "http://nationalmuseum.sg/exhibitions/exhibition-list#&&activeTab=Permanent&page=0");
        }
    }*/;

    public static HashMap<String, String> exhibitionClass = new HashMap<String, String>() /*{
        {
            put("Art Science Museum","http://www.marinabaysands.com/museum/exhibitions-and-events.html");
            put("National Museum of Singapore", "NationalMuseumCrawler");
            put("Singapore Art Museum", "SingaporeArtMuseumCrawler");
            put("National Gallery Singapore", "http://nationalmuseum.sg/exhibitions/exhibition-list#&&activeTab=Permanent&page=0");
        }
    }*/;

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
