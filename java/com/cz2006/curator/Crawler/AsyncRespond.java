package com.cz2006.curator.Crawler;

/**
 * AsyncRespond is an interface class for specifying callback function
 * when a crawler finish processing data.
 */
public interface AsyncRespond {
    /**
     * This function is a callback function when a crawler finish processing data.
     * @param output This is the data that is produced by a crawler.
     */
    void processFinish(Object output);
}
