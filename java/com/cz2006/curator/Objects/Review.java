package com.cz2006.curator.Objects;

import java.io.Serializable;
import java.util.Date;

/**
 * Review is a class to store details of a review of a certain museum.
 * This class is aggregated inside Museum Class.
 */
public class Review implements Serializable{

    private String authorName;
    private Date date;
    private Double rating;
    private String text;

    public Review(String authorName, Date date, Double rating, String text) {
        this.authorName = authorName;
        this.date = date;
        this.rating = rating;
        this.text = text;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
