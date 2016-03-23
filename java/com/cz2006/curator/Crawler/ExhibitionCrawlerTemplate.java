package com.cz2006.curator.Crawler;

import android.util.Log;

import com.cz2006.curator.Objects.Exhibition;

import org.jsoup.nodes.Document;

import java.util.ArrayList;

/**
 * Created by Acceleration on 21/03/2016.
 */
public abstract class ExhibitionCrawlerTemplate implements ExhibitionCrawlerInterface {
    //array list that contains list of exhibiton that has been crawled
    protected ArrayList<Exhibition> exhibitionList;
    protected Object adapter;
    protected Object elements;

    protected ExhibitionCrawlerTemplate() {
        exhibitionList = null;
        adapter = null;
        elements = null;
    }

    public void setAdapter(Object adapter) {
        this.adapter = adapter;
    }

    public void setExhibitionList(ArrayList<Exhibition> exhibitionList) {
        this.exhibitionList = exhibitionList;
    }

    public void refresh() {
        //initialize callback function when fetching document is okay
        AsyncRespond respond = new AsyncRespond() {
            @Override
            public void processFinish(Object output) {
                Log.e("process finish", "process finish");
                extractExhibition((Document) output);
            }
        };

        //run asynchronous thread
        ExhibitionCrawlerThread thread = new ExhibitionCrawlerThread(respond);
        thread.execute();
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
