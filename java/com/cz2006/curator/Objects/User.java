package com.cz2006.curator.Objects;

import java.io.Serializable;

/**
 * Created by Vicson on 18/3/2016.
 */
public class User implements Serializable {

    private double latitude;
    private double longitude;

    public User(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
