package com.cz2006.curator.Crawler;

/**
 * ExhibitionCrawlerInterface is an interface class to connect
 * ExhibitionManager and exhibition crawler
 */
public interface PlaceCrawlerInterface {
    /**
     * This method is to start fetching and processing data in a crawler. The process is in asynchronous manner.
     */
    void refresh();
}
