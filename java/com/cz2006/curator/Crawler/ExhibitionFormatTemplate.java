package com.cz2006.curator.Crawler;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.cz2006.curator.Objects.Exhibition;

import org.jsoup.nodes.Element;

import java.util.ArrayList;

/**
 * Created by Acceleration on 21/03/2016.
 */
public abstract class ExhibitionFormatTemplate extends AsyncTask<Void, Void, ArrayList<Exhibition>> implements ExhibitionCrawlerInterface {
    //array list that contains list of exhibiton that has been crawled
    protected ArrayList<Exhibition> exhibitionList;
    protected RecyclerView recyclerView;

    public ExhibitionFormatTemplate(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    private String getName(Element element) {
        return null;
    }

    private String getDuration(Element element) {
        return null;
    }

    private String getOrganizer(Element element) {
        return null;
    }

    private String getOpeningHours(Element element) {
        return null;
    }

    private String getFees(Element element) {
        return null;
    }

    private String getDescription(Element element) {
        return null;
    }

    private String getRestriction(Element element) {
        return null;
    }

    private String getTicketSite(Element element) {
        return null;
    }
}
