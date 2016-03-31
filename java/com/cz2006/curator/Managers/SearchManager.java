package com.cz2006.curator.Managers;

import com.cz2006.curator.Objects.Museum;
import com.cz2006.curator.Objects.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Prasanth on 18/03/2016.
 */
public class SearchManager {
    //attribute(s)
    private ArrayList<Museum> result;

    //user
    private User user;

    //constructor
    public SearchManager(ArrayList<Museum> result) {
        this.result = result;
    }

    //getters & setters
    public ArrayList<Museum> getResult() {
        return result;
    }

    public void setResult(ArrayList<Museum> result) {
        this.result = result;
    }

    //methods

    /**
     * TODO:
     * The constructor retrieves the list of all museums.
     */
    public SearchManager(){
        result = new ArrayList<Museum>();
    }

    //TODO make this work
    public ArrayList<Museum> search(String request) {
        return result;
    }

    public ArrayList<Museum> byProximity() {
        Collections.sort(result,new CmpByProximity());
        return result;
    }

    public class CmpByProximity implements Comparator<Museum>{
        @Override
        public int compare(Museum a, Museum b) {
            double distFromA = Math.sqrt(
                    (a.getLatitude() - user.getLatitude()) * (a.getLatitude() - user.getLatitude()) +
                    (a.getLongitude() - user.getLongitude()) * (a.getLongitude() - user.getLongitude())
            );
            double distFromB = Math.sqrt(
                    (b.getLatitude() - user.getLatitude()) * (b.getLatitude() - user.getLatitude()) +
                    (b.getLongitude() - user.getLongitude()) * (b.getLongitude() - user.getLongitude())
            );

            return ((distFromA < distFromB)?(-1):(1));
        }
    }

    public class CmpByRating implements Comparator<Museum>{
        @Override
        public int compare(Museum a, Museum b) {
            return ((a.getRating() > b.getRating())?(-1):(1));
        }
    }
}
