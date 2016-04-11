package com.cz2006.curator.Objects;

import java.io.Serializable;

/**
 * Created by Acceleration on 09/04/2016.
 */
public class Place  implements Serializable {

    private String name;
    private Double lat;
    private Double lng;
    private String placeId;
    private Double rating;
    private String address;

    public Place(String name, String address, Double lat, Double lng, Double rating, String placeId) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.placeId = placeId;
        this.rating = rating;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }
}
