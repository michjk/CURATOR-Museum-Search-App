package com.cz2006.curator.Managers;

import com.cz2006.curator.Crawler.ExhibitionCrawlerInterface;
import com.cz2006.curator.Crawler.SingaporeArtMuseumCrawler;
import com.cz2006.curator.Objects.Exhibition;

import java.util.ArrayList;

/**
 * Created by Acceleration on 25/03/2016.
 */
public class ExhibitionManager {

    private ArrayList<Exhibition> exhibitionList;
    private Object adapter;
    private ExhibitionCrawlerInterface crawler;

    public ExhibitionManager(ArrayList<Exhibition> exhibitionList, Object adapter) {
        this.exhibitionList = exhibitionList;
        this.adapter = adapter;
    }

    public void refresh() {
        crawler = new SingaporeArtMuseumCrawler();
        crawler.setExhibitionList(exhibitionList);
        crawler.setAdapter(adapter);
        crawler.refresh();
    }
}
