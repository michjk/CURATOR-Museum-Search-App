package com.cz2006.curator.Constants;

import java.util.HashMap;

/**
 * Created by Acceleration on 18/03/2016.
 */
public class ExhibitionConstants {
    public static HashMap<String, String> exhibitionUrl = new HashMap<String, String>() {
        {
            put("Art Science Museum","http://www.marinabaysands.com/museum/exhibitions-and-events.html");
            put("National Museum of Singapore", "http://nationalmuseum.sg/exhibitions/exhibition-list");
            put("Singapore Art Museum", "https://www.singaporeartmuseum.sg/exhibitions/current.html");
            put("National Gallery Singapore", "http://nationalmuseum.sg/exhibitions/exhibition-list#&&activeTab=Permanent&page=0");
        }
    };

    public static HashMap<String, String> exhibitionClass = new HashMap<String, String>() {
        {
            put("Art Science Museum","http://www.marinabaysands.com/museum/exhibitions-and-events.html");
            put("National Museum of Singapore", "NationalMuseumCrawler");
            put("Singapore Art Museum", "SingaporeArtMuseumCrawler");
            put("National Gallery Singapore", "http://nationalmuseum.sg/exhibitions/exhibition-list#&&activeTab=Permanent&page=0");
        }
    };

}
