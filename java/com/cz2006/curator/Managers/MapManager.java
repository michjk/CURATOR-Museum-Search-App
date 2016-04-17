package com.cz2006.curator.Managers;

import android.util.Log;

import com.cz2006.curator.Crawler.AsyncRespond;
import com.cz2006.curator.Crawler.PlaceCrawler;
import com.cz2006.curator.Crawler.PlaceCrawlerInterface;
import com.cz2006.curator.Objects.Museum;
import com.cz2006.curator.Objects.Place;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * MapManager is a class to control and manage MapUI. It acts as connector between
 * MapUI and PlaceCrawler.
 */
public class MapManager {

    private PlaceCrawlerInterface crawler;
    private ArrayList<Place> placeList;
    private GoogleMap mMap;

    /**
     * This is a constructor for MapManager.
     * @param map This is GoogleMap object for managing Google Map API.
     */
    public MapManager(GoogleMap map) {
        mMap = map;
    }

    /**
     * This is a method for getting list of museum crawled.
     * @return This is list of museum.
     */
    public ArrayList<Museum> getMuseumList(){
        if(placeList == null) return null;
        ArrayList<Museum> arr = new ArrayList<Museum>();
        for(Place p:placeList){
            arr.add(new Museum(p.getName(),p.getLat(),p.getLng(),"",p.getRating(),null,"","","","",null,null,p.getPlaceId()));
        }
        return arr;
    }

    /**
     *  This is method for executing PlaceCrawler and override AsyncRespond as callback function
     *  to display the result after the crawler finish.
     */
    public void refresh() {
        Log.e("refreshing", "please wait...");
        crawler = new PlaceCrawler(new AsyncRespond() {
            @Override
            public void processFinish(Object output) {
                placeList = (ArrayList)output;
                //write in here for updating the map
                if (mMap != null) {
                    for (Place p : placeList) {
                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(p.getLat(), p.getLng()))
                                .title(p.getName())
                                .snippet("Tap here for more info!")
                        );
                    }
                }

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

    /**
     * This is a method to get place ID of a certain museum
     * @param museumName This is the name of a museum.
     * @return The place ID of a certain museum. It return null if does not match.
     */
    public String findID(String museumName) {
        for(Place p: placeList) {
            if (p.getName().equals(museumName))
                return p.getPlaceId();
        }
        return null;    // return null if no match
    }

}
