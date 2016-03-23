package com.cz2006.curator.Crawler;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cz2006.curator.Objects.Exhibition;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Acceleration on 24/03/2016.
 */
public class NationalMuseumCrawler extends ExhibitionCrawlerTemplate  {
    public NationalMuseumCrawler() {
        super();
    }

    @Override
    protected void extractExhibition(Object document) {
        elements = ((Document)document).select(".tab-content");
        //Reset list
        exhibitionList.clear();

        //Process each section
        for (Element e: (Elements)elements) {
            Exhibition exhibition = new Exhibition(getName(e), getOrganizer(e), getOpeningHours(e),
                    getFees(e), getRestriction(e), getDuration(e), getDescription(e), null, getTicketSite(e));
            exhibitionList.add(exhibition);
        }

        ((RecyclerView.Adapter)adapter).notifyDataSetChanged();
    }

    @Override
    protected String getName(Object element) {
        return ((Element)element).select(".content-title").text();
    }

    @Override
    protected String getDuration(Object element) {
        return ((Element)element).select(".date").text();
    }

    @Override
    protected String getOrganizer(Object element) {
        return super.getOrganizer(element);
    }

    @Override
    protected String getOpeningHours(Object element) {
        Log.e("opening hours", ((Element)element).select(".time").text());
        return ((Element)element).select(".time").text();
    }

    @Override
    protected String getFees(Object element) {
        return super.getFees(element);
    }

    @Override
    protected String getDescription(Object element) {
        return ((Element)element).select(".event-contents").text();
    }

    @Override
    protected String getRestriction(Object element) {
        return super.getRestriction(element);
    }

    @Override
    protected String getTicketSite(Object element) {
        return super.getTicketSite(element);
    }
}
