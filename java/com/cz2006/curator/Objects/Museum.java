package com.cz2006.curator.Objects;

/**
 * Created by Vicson on 18/3/2016.
 */
public class Museum {

    private String name;
    private double latitude;
    private double longitude;
    private String address;
    private double rating;
    private String openingHours;
    private String fees;
    private String restriction;
    private String description;
    private String ticketSite;
    // arraylist of reviews and exhibitions are not implemented yet

    public Museum(String name, double latitude, double longitude, String address, double rating, String openingHours, String fees, String restriction, String description, String ticketSite) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.rating = rating;
        this.openingHours = openingHours;
        this.fees = fees;
        this.restriction = restriction;
        this.description = description;
        this.ticketSite = ticketSite;
    }

    public Museum(int id){
        name = "Sample Museum " + id;
        latitude = 2.0;
        longitude = 1.0;
        address = "";
        rating = 5.0;
        openingHours = "7am-19pm";
        fees = "$5";
        restriction = "";
        description = "The Sample Museum " + id + " is a sample museum.";
        ticketSite = "";
    }

    // Here be getter/setters; abandon hope all ye who enter

    public String getTicketSite() {
        return ticketSite;
    }

    public void setTicketSite(String ticketSite) {
        this.ticketSite = ticketSite;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
