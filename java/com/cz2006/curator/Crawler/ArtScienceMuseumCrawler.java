package com.cz2006.curator.Crawler;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by Acceleration on 21/03/2016.
 */
public class ArtScienceMuseumCrawler extends ExhibitionCrawlerTemplate{
    @Override
    protected void extractExhibition(Document document) {
    }

    @Override
    protected String getName(Element element) {
        return super.getName(element);
    }

    @Override
    protected String getDuration(Element element) {
        return super.getDuration(element);
    }

    @Override
    protected String getOrganizer(Element element) {
        return super.getOrganizer(element);
    }

    @Override
    protected String getOpeningHours(Element element) {
        return super.getOpeningHours(element);
    }

    @Override
    protected String getFees(Element element) {
        return super.getFees(element);
    }

    @Override
    protected String getDescription(Element element) {
        return super.getDescription(element);
    }

    @Override
    protected String getRestriction(Element element) {
        return super.getRestriction(element);
    }

    @Override
    protected String getTicketSite(Element element) {
        return super.getTicketSite(element);
    }
}
