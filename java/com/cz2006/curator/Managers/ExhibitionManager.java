package com.cz2006.curator.Managers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;

import com.cz2006.curator.Crawler.AsyncRespond;
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
    private ProgressBar spinner;
    private String museumName;


    public ExhibitionManager(ArrayList<Exhibition> exhibitionList, Object adapter, Context context, ProgressBar spinner, String museumName) {
        this.exhibitionList = exhibitionList;
        this.adapter = adapter;
        this.context = context;
        this.spinner = spinner;
        this.museumName = museumName;
    }

    public void refresh() {
        crawler = ExhibitionDataFactory.getExhibitionCrawler(museumName, context);
        //crawler.setExhibitionList(exhibitionList);
        //crawler.setAdapter(adapter);

        if(crawler == null) {
            Log.e("hello", crawler.toString());
        }

        crawler.setAsyncRespond(new AsyncRespond() {
            @Override
            public void processFinish(Object output) {
                exhibitionList.clear();
                ArrayList<Exhibition> tmpList = (ArrayList<Exhibition>) output;
                for(Exhibition exhibition: tmpList) {
                    exhibitionList.add(exhibition);
                }
                ((RecyclerView.Adapter)adapter).notifyDataSetChanged();
            }
        });

        crawler.refresh();
    }
}
