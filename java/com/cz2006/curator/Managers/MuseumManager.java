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
 * Created by Acceleration on 10/04/2016.
 */
public class MuseumManager {

    private MuseumCrawlerInterface crawler;
    private String placeId;
    private GoogleApiClient mGoogleApiClient;
    private MuseumUI museumUI;
    private Museum museum;

    public Museum getMuseum() {
        return museum;
    }

    public MuseumManager(String placeId, GoogleApiClient mGoogleApiClient, MuseumUI ui) {
        this.placeId = placeId;
        this.mGoogleApiClient = mGoogleApiClient;
        this.museumUI = ui;
    }

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
