package com.cz2006.curator.Managers;

import android.util.Log;

import com.cz2006.curator.Crawler.AsyncRespond;
import com.cz2006.curator.Crawler.MuseumCrawlerInterface;
import com.cz2006.curator.Crawler.MuseumCrawler;
import com.cz2006.curator.Dialogs.GenericAlertDialog;
import com.cz2006.curator.Objects.Museum;
import com.cz2006.curator.UI.MuseumUI;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * MuseumManager is a class to control and manage MuseumUI. It acts as connector between
 * MuseumUI and MuseumCrawler.
 */
public class MuseumManager {

    private MuseumCrawlerInterface crawler;
    private String placeId;
    private GoogleApiClient mGoogleApiClient;
    private MuseumUI museumUI;
    private Museum museum;

    /**
     * This is a method to get a museum that has been crawled.
     * @return a museum that has been crawled.
     */
    public Museum getMuseum() {
        return museum;
    }

    /**
     * This is constructor of MuseumMananger
     * @param placeId  ID of a museum.
     * @param mGoogleApiClient client object to manage Google Place API.
     * @param ui MuseumUI object which is managed by MuseumManager.
     */
    public MuseumManager(String placeId, GoogleApiClient mGoogleApiClient, MuseumUI ui) {
        this.placeId = placeId;
        this.mGoogleApiClient = mGoogleApiClient;
        this.museumUI = ui;
    }

    /**
     *  This is method for executing MuseumCrawler and override AsyncRespond as callback function
     *  to display the result after the crawler finish.
     */
    public void refresh() {
        Log.e("is place still here", placeId.toString());
        crawler = new MuseumCrawler(placeId, mGoogleApiClient, new AsyncRespond() {
            @Override
            public void processFinish(Object output) {
                //write code here to program what to do after get museum data
                //current available data: name, rating, arraylist of opening hours, image, arraylist of review
                museum = (Museum) output;
                if (museum != null) museumUI.displayData(museum);
                else {
                    Log.e("Museum cannot be null", museum.toString());
                    GenericAlertDialog genericAlertDialog = new GenericAlertDialog();
                    genericAlertDialog.show(museumUI.getFragmentManager(), "Selected museum was set to 'null'!");
                }
            }
        });
        crawler.refresh();
    }

}
