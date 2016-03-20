package com.cz2006.curator.Objects;

/**
 * Created by Acceleration on 21/03/2016.
 */
public class Exhibition {
    private String name;
    private String organizer;
    private String openingHours;
    private String fees;
    private String restriction;
    private String duration;
    private String ticketSite;

    public Exhibition(String name, String organizer, String openingHours, String fees, String restriction, String duration, String ticketSite) {
        this.name = name;
        this.organizer = organizer;
        this.openingHours = openingHours;
        this.fees = fees;
        this.restriction = restriction;
        this.duration = duration;
        this.ticketSite = ticketSite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTicketSite() {
        return ticketSite;
    }

    public void setTicketSite(String ticketSite) {
        this.ticketSite = ticketSite;
    }
}
