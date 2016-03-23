package com.cz2006.curator.Managers;

import com.cz2006.curator.Objects.Museum;
import com.cz2006.curator.Objects.User;

import java.util.*;

public class SearchEngine{
    //attribute(s)
    private ArrayList<Museum> result;

    //user
    private User user;

    //constructor
    public SearchEngine() {
        User u = new User(0,0);
        result = new ArrayList<Museum>();
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
        if(result.size() == 0)
            for(int i=1;i<=20;i++)
                result.add(new Museum(i));
        return result;
    }

    public ArrayList<Museum> byProximity() {
        search();
        //Collections.sort(result, new CmpByProximity());
        return result;
    }

    public ArrayList<Museum> byRating() {
        search();
        //Collections.sort(result, new CmpByRating());
        return result;
    }

    public class CmpByProximity implements Comparator<Museum> {
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
