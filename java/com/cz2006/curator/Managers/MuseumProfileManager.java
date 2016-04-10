package com.cz2006.curator.Managers;

import com.cz2006.curator.Crawler.AsyncRespond;
import com.cz2006.curator.Crawler.MuseumProfileCrawlerInterface;
import com.cz2006.curator.Crawler.MuseumProfileCrawler;
import com.cz2006.curator.Objects.Museum;
import com.cz2006.curator.UI.MuseumProfileUI;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Acceleration on 10/04/2016.
 */
public class MuseumProfileManager {

    private MuseumProfileCrawlerInterface crawler;
    private String placeId;
    private GoogleApiClient mGoogleApiClient;
    private MuseumProfileUI museumUI;
    private Museum museum;

    public MuseumProfileManager(String placeId, GoogleApiClient mGoogleApiClient, MuseumProfileUI ui) {
        this.placeId = placeId;
        this.mGoogleApiClient = mGoogleApiClient;
        this.museumUI = ui;
    }

    public void refresh() {
        crawler = new MuseumProfileCrawler(placeId, mGoogleApiClient, new AsyncRespond() {
            @Override
            public void processFinish(Object output) {
                //write code here to program what to do after get museum data
                //current available data: name, rating, arraylist of opening hours, image, arraylist of review
                museum = (Museum) output;
                museumUI.displayData(museum);
            }
        });

        crawler.refresh();
    }

}
