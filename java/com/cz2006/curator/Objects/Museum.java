package com.cz2006.curator.Objects;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by Vicson on 18/3/2016.
 */
public class Museum {

    private String name;
    private double latitude;
    private double longitude;
    private String address;
    private double rating;
    private ArrayList<String> openingHours;
    private Bitmap image;
    private String fees;
    private String restriction;
    private String description;
    private String ticketSite;
    private ArrayList<Review> reviewList;
    // arraylist of reviews and exhibitions are not implemented yet

    public Museum(String name, double latitude, double longitude, String address, double rating, ArrayList<String> openingHours, String fees, String restriction, String description, String ticketSite, ArrayList<Review> reviewList, Bitmap image) {
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
        this.reviewList = reviewList;
        this.image = image;
    }



    public Museum(int id){
        name = "Sample Museum " + id;
        latitude = 2.0;
        longitude = 1.0;
        address = "";
        rating = 5.0;
        openingHours = null;
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

    public ArrayList<String> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(ArrayList<String> openingHours) {
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

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public ArrayList<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(ArrayList<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
