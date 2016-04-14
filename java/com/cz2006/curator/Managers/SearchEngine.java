package com.cz2006.curator.Managers;

import android.os.Environment;
import android.util.Log;

import com.cz2006.curator.Objects.Museum;
import com.cz2006.curator.Objects.Place;
import com.cz2006.curator.Objects.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

public class SearchEngine{
    //attribute(s)
    private ArrayList<Museum> result;

    //user
    private User user;

    //constructor
    public SearchEngine(ArrayList<Museum> arr, User u) {
        user = u;
        result = arr;
    }

    //getters & setters
    public ArrayList<Museum> getResult() {
        return result;
    }

    public void setResult(ArrayList<Museum> result) {
        this.result = result;
    }

    //methods

    //TODO make this work
    public ArrayList<Museum> search() {
        if(result.size() == 0) {
            //for (int i = 1; i <= 20; i++)
            //    result.add(new Museum(i));

        }
        return result;
    }

    public ArrayList<Museum> byProximity() {
        Collections.sort(result,new CmpByProximity());
        return result;
    }

    public ArrayList<Museum> byRating() {
        Collections.sort(result, new CmpByRating());
        return result;
    }

    public class CmpByProximity implements Comparator<Museum> {

        public double dist(double lat1, double lon1, double lat2, double lon2){
            double R = 6371000;
            double p1 = Math.toRadians(lat1);
            double p2 = Math.toRadians(lat2);
            double dp = Math.toRadians(lat2-lat1);
            double dl = Math.toRadians(lon2-lon1);

            double a = Math.sin(dp/2.0) * Math.sin(dp/2.0)
                    + Math.cos(p1/2.0) * Math.cos(p2/2.0) * Math.sin(dl/2.0) * Math.sin(dl/2.0);

            double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

            return R * c;
        }

        @Override
        public int compare(Museum a, Museum b) {
            double d1 = dist(a.getLatitude(),a.getLongitude(),user.getLatitude(),user.getLongitude());
            double d2 = dist(b.getLatitude(),b.getLongitude(),user.getLatitude(),user.getLongitude());

            return ((d1 < d2)?(-1):(1));
        }
    }

    public class CmpByRating implements Comparator<Museum>{
        @Override
        public int compare(Museum a, Museum b) {
            return ((a.getRating() > b.getRating())?(-1):(1));
        }
    }
}