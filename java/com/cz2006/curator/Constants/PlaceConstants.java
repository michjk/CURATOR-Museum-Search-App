package com.cz2006.curator.Constants;

/**
 * PlaceConstants is a class that contains constants related to
 * PlaceCrawler class.
 */
public class PlaceConstants {

    //select only one of the following keys at a time
    private static final String API_KEY = "AIzaSyAMA_EoylT2Dz_grch1O9Wd8bziEpKzAg4";
    //private static final String API_KEY = "AIzaSyDuxQ0E7rKTxqVWDvr2YQegWQWJ1wJnuT0";
    //private static final String API_KEY = "AIzaSyAiaOUB4sQnnkyNZeo63hGHjFrYX8UEB6E";
    //private static final String API_KEY = "AIzaSyBu-K8O-hJF_iByWggp7y6b36KmBnb7xI0";
    //private static final String API_KEY = "AIzaSyArqFUbafO3xHWJLapd2MdEoDxxkSuLYkE";

    /**
     * This constant contains URL to request XML from google place API to get list of museum.
     */
    public static String URL = "https://maps.googleapis.com/maps/api/place/textsearch/xml?query=museums+in+Singapore&key=" + API_KEY;

    /**
     * This constant contains name of XML tag of a result.
     */
    public static final String KEY_ITEM = "result"; // parent node

    /**
     * This constant contains name of XML tag of museum place id.
     */
    public static final String KEY_ID = "place_id";

    /**
     * This constant contains name of XML tag of museum name.
     */
    public static final String KEY_NAME = "name";

    /**
     * This constant contains name of XML tag of latitude of a museum.
     */
    public static final String KEY_LAT = "lat";

    /**
     * This constant contains name of XML tag of longitude of a museum.
     */
    public static final String KEY_LNG = "lng";

    /**
     * This constant contains name of XML tag of rating of a museum.
     */
    public static final String KEY_RATING = "rating";

}
