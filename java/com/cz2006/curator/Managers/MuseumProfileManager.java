package com.cz2006.curator.Managers;

import com.cz2006.curator.Crawler.AsyncRespond;
import com.cz2006.curator.Crawler.MuseumProfileCrawlerInterface;
import com.cz2006.curator.Crawler.MuseumProfileCrawler;

/**
 * Created by Acceleration on 10/04/2016.
 */
public class MuseumProfileManager {

    private MuseumProfileCrawlerInterface crawler;
    private String placeId;

    public MuseumProfileManager(String placeId) {
        this.placeId = placeId;
    }

    public void refresh() {
        crawler = new MuseumProfileCrawler(placeId, new AsyncRespond() {
            @Override
            public void processFinish(Object output) {

            }
        });

        crawler.refresh();
    }

}
