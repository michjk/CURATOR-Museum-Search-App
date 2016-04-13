package com.cz2006.curator.Constants;

/**
 * Created by Acceleration on 09/04/2016.
 */
public class PlaceConstants {

    //*  <<- Add/remove one '/' here to toggle between key 1 and key 2
    private static final String API_KEY = "AIzaSyAMA_EoylT2Dz_grch1O9Wd8bziEpKzAg4";
    /*/
    private static final String API_KEY = "AIzaSyAiaOUB4sQnnkyNZeo63hGHjFrYX8UEB6E";
    //*/
    public static String URL = "https://maps.googleapis.com/maps/api/place/textsearch/xml?query=museums+in+Singapore&key=" + API_KEY;
    public static final String KEY_ITEM = "result"; // parent node
    public static final String KEY_ID = "place_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_LAT = "lat";
    public static final String KEY_LNG = "lng";
    public static final String KEY_RATING = "rating";

    /*  <<- Add/remove one '/' here to toggle active code block
    String mode = "release";
    /*/
    String mode = "debug";
    //*/

}
