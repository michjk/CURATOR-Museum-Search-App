package com.cz2006.curator.Crawler;

import android.support.v7.widget.RecyclerView;

import com.cz2006.curator.Objects.Exhibition;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by Acceleration on 21/03/2016.
 */
public abstract class ExhibitionCrawlerTemplate implements ExhibitionCrawlerInterface {
    //array list that contains list of exhibiton that has been crawled
    protected ArrayList<Exhibition> exhibitionList;
    protected RecyclerView.Adapter adapter;
    protected Elements elements;

    protected ExhibitionCrawlerTemplate() {
        exhibitionList = null;
        adapter = null;
        elements = null;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }

    public void setExhibitionList(ArrayList<Exhibition> exhibitionList) {
        this.exhibitionList = exhibitionList;
    }

    public void refresh() {
        //initialize callback function when fetching document is okay
        AsyncRespond respond = new AsyncRespond() {
            @Override
            public void processFinish(Object output) {
                extractExhibition((Document)output);
            }
        };

        //run asynchronous thread
        ExhibitionCrawlerThread thread = new ExhibitionCrawlerThread(respond);
        thread.execute();
    }

    protected abstract void extractExhibition(Document document);

    protected String getName(Element element) {
        return null;
    }

    protected String getDuration(Element element) {
        return null;
    }

    protected String getOrganizer(Element element) {
        return null;
    }

    protected String getOpeningHours(Element element) {
        return null;
    }

    protected String getFees(Element element) {
        return null;
    }

    protected String getDescription(Element element) {
        return null;
    }

    protected String getRestriction(Element element) {
        return null;
    }

    protected String getTicketSite(Element element) {
        return null;
    }
}
