package com.cz2006.curator.Managers;

import com.cz2006.curator.Objects.Museum;

import java.util.ArrayList;

/**
 * Created by Prasanth on 18/03/2016.
 */
public class SearchManager {

    //attribute(s)
    private ArrayList<Museum> result;

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
    //TODO make this work
    public ArrayList<Museum> search(String request) {
        return result;
    }

    //TODO make this work
    public ArrayList<Museum> byProximity() {
        return result;
    }
/*
    //TODO test this
    public Boolean compareByProximity (Museum A, Museum B){
        double distFromA = Math.sqrt((A.latitude - user.latitude) * (A.latitude-user.latitude)
                + (A.longitude - user.longitude) * (A.longitude-user.longitude));
        double distFromB = Math.sqrt((B.latitude - user.latitude) * (B.latitude-user.latitude)
                + (B.longitude - user.longitude) * (B.longitude-user.longitude));
        if (distFromA > distFromB)
            return true;
        else return false;
    }

    //TODO make this work
    public ArrayList<Museum> byRating () {
        return result;
    }

    //TODO test this
    public Boolean compareByRating (Museum A, Museum B) {
        if (A.rating > B.rating)
            return true;
        else return false;
    }*/
}
