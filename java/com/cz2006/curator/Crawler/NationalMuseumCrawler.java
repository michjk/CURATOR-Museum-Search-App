package com.cz2006.curator.Crawler;

import android.util.Log;

import com.cz2006.curator.Objects.Exhibition;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
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
    protected Void doInBackground(Void... params) {
        try {
            //Establish connection to exhibition page
            Connection con = Jsoup
                    .connect("http://nationalmuseum.sg/exhibitions/exhibition-list#&&activeTab=Permanent&page=0")
                    .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                    .timeout(10000);
            Connection.Response resp = con.execute();

            //Crawl if successful
            if(resp.statusCode() == 200) {
                //Get exhibition section from the page
                Document doc = con.get();
                extractExhibition(doc);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void v) {
        //((RecyclerView.Adapter)adapter).notifyDataSetChanged();
        asyncRespond.processFinish(exhibitionList);
    }

    @Override
    protected void extractExhibition(Object document) {
        Object elements = ((Document)document).select(".tab-content");
        //Reset list
        exhibitionList.clear();

        //Process each section
        for (Element e: (Elements)elements) {
            Exhibition exhibition = new Exhibition(getName(e), getOrganizer(e), getOpeningHours(e),
                    getFees(e), getRestriction(e), getDuration(e), getDescription(e), null, getTicketSite(e));
            exhibitionList.add(exhibition);
        }
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
