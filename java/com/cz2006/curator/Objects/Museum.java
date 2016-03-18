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
