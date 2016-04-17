package com.cz2006.curator.Crawler;

/**
 * ExhibitionCrawlerInterface is an interface class to connect
 * ExhibitionManager and exhibition crawler
 */
public interface ExhibitionCrawlerInterface {

    /**
     * This method is to start fetching and processing data in a crawler.
     */
    void refresh();

    /**
     * This method is to set class that contains callback function.
     * The callback function is to pass data from crawler to manager.
     * @param asyncRespond This parameter is for specifying callback function when a crawler finish processing data.
     */
    void setAsyncRespond(AsyncRespond asyncRespond);
}
