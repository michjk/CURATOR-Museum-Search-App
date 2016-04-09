package com.cz2006.curator.Managers;

import android.util.Log;

import com.cz2006.curator.Crawler.AsyncRespond;
import com.cz2006.curator.Crawler.PlaceCrawler;
import com.cz2006.curator.Crawler.PlaceCrawlerInterface;
import com.cz2006.curator.Objects.Place;

import java.util.ArrayList;

/**
 * Created by Prasanth on 18/03/2016.
 */
public class MapManager {

    private PlaceCrawlerInterface crawler;
    private ArrayList<Place> placeList;

    public void refresh() {
        Log.e("adda","adjaiodf");
        crawler = new PlaceCrawler(new AsyncRespond() {
            @Override
            public void processFinish(Object output) {
                placeList = (ArrayList)output;
                //write in here for updating the map
                for(Place p: placeList) {
                    Log.e("MapManager", p.getName());
                    Log.e("MapManager", p.getLat()+"");
                    Log.e("MapManager", p.getLng()+"");
                    Log.e("MapManager", p.getPlaceId());
                }
            }
        });
        crawler.refresh();
    }

}
