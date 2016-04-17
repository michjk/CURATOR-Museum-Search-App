package com.cz2006.curator.Crawler;

/**
 * PlaceCrawlerInterface is an interface class to connect
 * MapManager and PlaceCrawler
 */
public interface PlaceCrawlerInterface {
    /**
     * This method is to start fetching and processing data in a crawler. The process is in asynchronous manner.
     */
    void refresh();
}
