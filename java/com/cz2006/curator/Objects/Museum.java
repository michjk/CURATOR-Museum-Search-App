package com.cz2006.curator.Objects;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Museum is an entity class for storing data of a museum.
 */
public class Museum implements Serializable{

    private String name;
    private double latitude;
    private double longitude;
    private String address;
    private double rating;
    private ArrayList<String> openingHours;
    private Bitmap image;
    private String phone;
    private String email;
    private String description;
    private String ticketSite;
    private ArrayList<Review> reviewList;
    private String placeID;

    public Museum(String name, double latitude, double longitude, String address, double rating, ArrayList<String> openingHours, String phone, String email, String description, String ticketSite, ArrayList<Review> reviewList, Bitmap image,String placeID){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.rating = rating;
        this.openingHours = openingHours;
        this.phone = phone;
        this.email = email;
        this.description = description;
        this.ticketSite = ticketSite;
        this.reviewList = reviewList;
        this.image = image;
        this.placeID = placeID;
    }



    public Museum(int id){
        name = "Sample Museum " + id;
        latitude = 2.0;
        longitude = 1.0;
        address = "";
        rating = 5.0;
        openingHours = null;
        phone = "";
        email = "";
        description = "The Sample Museum " + id + " is a sample museum.";
        ticketSite = "";
    }

    public String getPlaceID(){
        return placeID;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
