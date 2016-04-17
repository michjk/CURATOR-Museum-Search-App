package com.cz2006.curator.Crawler;

/**
 * MuseumCrawlerInterface is an interface class to connect
 * MuseumManager and MuseumCrawler
 */
public interface MuseumCrawlerInterface {

    /**
     * This method is to start fetching and processing data in a crawler.
     */
    void refresh();
}
