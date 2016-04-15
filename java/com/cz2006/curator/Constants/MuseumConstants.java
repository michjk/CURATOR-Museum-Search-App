package com.cz2006.curator.Constants;

/**
 * Created by Acceleration on 09/04/2016.
 */
public class MuseumConstants {

    //select only one of the following keys at a time
    private static final String API_KEY = "AIzaSyAMA_EoylT2Dz_grch1O9Wd8bziEpKzAg4";
    //private static final String API_KEY = "AIzaSyDuxQ0E7rKTxqVWDvr2YQegWQWJ1wJnuT0";
    //private static final String API_KEY = "AIzaSyAiaOUB4sQnnkyNZeo63hGHjFrYX8UEB6E";
    //private static final String API_KEY = "AIzaSyBDt3csb4pRV8WakW3IXOd-d9HpgiADJAc";
    //private static final String API_KEY = "AIzaSyArqFUbafO3xHWJLapd2MdEoDxxkSuLYkE";


    public static String URL = "https://maps.googleapis.com/maps/api/place/details/json?key=" + API_KEY + "&placeid=";
    public static final String KEY_ITEM = "result"; // parent node
    public static final String KEY_ID = "place_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_LAT = "lat";
    public static final String KEY_LNG = "lng";
}
