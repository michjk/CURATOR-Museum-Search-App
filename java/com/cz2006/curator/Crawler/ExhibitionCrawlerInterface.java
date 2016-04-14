package com.cz2006.curator.Crawler;

/**
 * Created by Acceleration on 20/03/2016.
 */
public interface ExhibitionCrawlerInterface {
    public void refresh();
    //public void setAdapter(Object adapter);
    //public void setExhibitionList(ArrayList<Exhibition> exhibitionList);
    public void setAsyncRespond(AsyncRespond asyncRespond);
}
