package com.cz2006.curator.Managers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.cz2006.curator.Crawler.AsyncRespond;
import com.cz2006.curator.Crawler.ExhibitionCrawlerInterface;
import com.cz2006.curator.Objects.Exhibition;

import java.util.ArrayList;

/**
 * ExhibitionManager is a class to control and manage ExhibitionUI. It acts as connector between
 * ExhibitionUI and ExhibitionCrawler.
 */
public class ExhibitionManager {

    private ArrayList<Exhibition> exhibitionList;
    private Object adapter;
    private ExhibitionCrawlerInterface crawler;
    private Context context;
    private ProgressBar spinner;
    private String museumName;

    /**
     * This is a constructor for ExhibitionManager.
     * @param exhibitionList This is parameter for list of exhibition
     * @param adapter This is adapter for managing RecyclerView
     * @param context This is context of current activity/UI class
     * @param spinner This is object to generate Progress Bar
     * @param museumName This is name of museum who has exhibitions that can be crawled.
     */
    public ExhibitionManager(ArrayList<Exhibition> exhibitionList, Object adapter, Context context, ProgressBar spinner, String museumName) {
        this.exhibitionList = exhibitionList;
        this.adapter = adapter;
        this.context = context;
        this.spinner = spinner;
        this.museumName = museumName;
    }

    /**
     *  This is method for executing ExhibitionCrawler and override AsyncRespond as callback function
     *  to display the result after the crawler finish.
     */
    public void refresh() {
        crawler = ExhibitionDataFactory.getExhibitionCrawler(museumName, context);
        //crawler.setExhibitionList(exhibitionList);
        //crawler.setAdapter(adapter);

        spinner.setVisibility(View.VISIBLE);

        if(crawler == null) {
            Log.e("hello", crawler.toString());
        }

        spinner.setVisibility(View.VISIBLE);
        crawler.setAsyncRespond(new AsyncRespond() {
            @Override
            public void processFinish(Object output) {
                exhibitionList.clear();
                ArrayList<Exhibition> tmpList = (ArrayList<Exhibition>) output;
                for(Exhibition exhibition: tmpList) {
                    exhibitionList.add(exhibition);
                }
                ((RecyclerView.Adapter)adapter).notifyDataSetChanged();
                spinner.setVisibility(View.GONE);
            }
        });

        crawler.refresh();
    }
}
