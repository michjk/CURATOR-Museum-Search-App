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
 * Created by Prasanth on 18/03/2016.
 */
public class MapManager {

    private PlaceCrawlerInterface crawler;
    private ArrayList<Place> placeList;
    private GoogleMap mMap;

    public MapManager(GoogleMap map) {
        mMap = map;
    }
    
    public ArrayList<Museum> getMuseumList(){
        if(placeList == null) return null;
        ArrayList<Museum> arr = new ArrayList<Museum>();
        for(Place p:placeList){
            arr.add(new Museum(p.getName(),p.getLat(),p.getLng(),"",p.getRating(),null,"","","","",null,null,p.getPlaceId()));
        }
        return arr;
    }

    public void refresh() {
        Log.e("adda","adjaiodf");
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

    public String findID(String museumName) {
        for(Place p: placeList) {
            if (p.getName().equals(museumName))
                return p.getPlaceId();
        }
        return null;    // return null if no match
    }

}
