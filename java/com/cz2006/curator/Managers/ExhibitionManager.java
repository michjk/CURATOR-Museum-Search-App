package com.cz2006.curator.Managers;

import android.content.Context;

import com.cz2006.curator.Crawler.ExhibitionCrawlerInterface;
import com.cz2006.curator.Objects.Exhibition;

import java.util.ArrayList;

/**
 * Created by Acceleration on 25/03/2016.
 */
public class ExhibitionManager {

    private ArrayList<Exhibition> exhibitionList;
    private Object adapter;
    private ExhibitionCrawlerInterface crawler;
    private Context context;


    public ExhibitionManager(ArrayList<Exhibition> exhibitionList, Object adapter, Context context) {
        this.exhibitionList = exhibitionList;
        this.adapter = adapter;
        this.context = context;
    }

    public void refresh() {
        crawler = ExhibitionDataFactory.getExhibitionCrawler("Singapore Art Museum", context);

        //Object object = new SingaporeArtMuseumCrawler();

        //crawler = new SingaporeArtMuseumCrawler();
        crawler.setExhibitionList(exhibitionList);
        crawler.setAdapter(adapter);
        crawler.refresh();
    }
}
