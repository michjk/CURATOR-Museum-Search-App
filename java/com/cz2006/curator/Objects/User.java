package com.cz2006.curator.Objects;

import java.io.Serializable;

/**
 * User iss a class for storing current location of the user.
 * This class is used for Map and Search feature.
 */
public class User implements Serializable{

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
