package com.cz2006.curator.Crawler;

import android.os.AsyncTask;

import com.cz2006.curator.Objects.Exhibition;

import java.util.ArrayList;

/**
 * ExhibitionCrawlerTemplate is a class that act as template of specific exhibition crawlers.
 * The class implement ExhibitionCrawlerInterface as connector to manager.
 * The template contains methods to extract specific data from html exhibition page, but the methods
 * return null. The methods need to be overridden in subclasses to implement algorithm for extracting data.
 */
public abstract class ExhibitionCrawlerTemplate extends AsyncTask<Void,Void,Void> implements ExhibitionCrawlerInterface {
    //array list that contains list of exhibiton that has been crawled
    protected ArrayList<Exhibition> exhibitionList;

    /**
     * This is an object for specifying callback function
     * when a crawler finish processing data.
     */
    public AsyncRespond asyncRespond;
    //protected Object adapter;


    protected ExhibitionCrawlerTemplate() {
        exhibitionList = new ArrayList<>();
        //adapter = null;
    }

    /**
     * This method is to set class that contains callback function.
     * The callback function is to pass data from crawler to manager.
     * @param asyncRespond for specifying callback function when a crawler finish processing data.
     */
    public void setAsyncRespond(AsyncRespond asyncRespond) {
        this.asyncRespond = asyncRespond;
    }

    /**
     * This method is for starting fetching and processing data in a crawler.
     */
    public void refresh() {
        this.execute();
    }

    protected abstract void extractExhibition(Object document);

    protected String getName(Object element) {
        return null;
    }

    protected String getDuration(Object element) {
        return null;
    }

    protected String getOrganizer(Object element) {
        return null;
    }

    protected String getOpeningHours(Object element) {
        return null;
    }

    protected String getFees(Object element) {
        return null;
    }

    protected String getDescription(Object element) {
        return null;
    }

    protected String getRestriction(Object element) {
        return null;
    }

    protected String getTicketSite(Object element) {
        return null;
    }
}
