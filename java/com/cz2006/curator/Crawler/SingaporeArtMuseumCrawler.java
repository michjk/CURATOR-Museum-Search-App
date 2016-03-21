package com.cz2006.curator.Crawler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.cz2006.curator.Objects.Exhibition;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Acceleration on 21/03/2016.
 */
public class SingaporeArtMuseumCrawler extends ExhibitionCrawlerTemplate {

    public SingaporeArtMuseumCrawler() {
        super();
    }

    protected void extractExhibition (Document document) {
        elements = document.select("article");
        //Reset list
        exhibitionList.clear();

        //Process each section
        for (Element e: elements) {
            Exhibition exhibition = new Exhibition(getName(e), getOrganizer(e), getOpeningHours(e),
            getFees(e), getRestriction(e), getDuration(e), getDescription(e), null, getTicketSite(e));
            exhibitionList.add(exhibition);
        }

        adapter.notifyDataSetChanged();
    }

    protected String getName(Element element) {
        return element.select(".MainTitle").text();
    }

    protected String getDuration(Element element) {
        return element.select("p strong").get(0).text();
    }

    protected String getDescription(Element element) {
        Elements content = element.select("div.col-left");
        if(content.size() == 0)
            content = element.select("div[style=float:left; width:380px; ]");
        if(content.size() == 0)
            content = element.select("div[style=float:right; width:470px; ]");
        if(content.size() == 0)
            content = element.select("div p span");

        return content.text();
    }

    protected Bitmap getImage(Element element) {

        //Get a container where img tag is located
        Elements imageTag =element.select(".col-right");
        if(imageTag.size()==0)
            imageTag =  element.select("div[style=float:right; margin:10px 0px 0px 20px; width:350px; ]");
        if(imageTag.size()==0)
            imageTag = element.select("div[style=float:right; margin:0px 0px 0px 0px; width:350px; ]");
        if(imageTag.size()==0)
            imageTag = element.select("div[style=float:left; margin:20px 20px 0px 0px; width:260px; ]");

        String imageUrl = null;

        //Get image url
        try {
            imageUrl = imageTag.select("img").get(0).attr("src");
            if (imageUrl.startsWith("..")) {
                imageUrl = imageUrl.replaceFirst("..", "https://www.singaporeartmuseum.sg");
            }
            else if(!imageUrl.startsWith("https://www.singaporeartmuseum.sg/exhibitions/")) {
                imageUrl = "https://www.singaporeartmuseum.sg/exhibitions/" + imageUrl;
            }
        }catch(Exception f) {
            f.printStackTrace();
        }

        Bitmap bm = null;

        //Get bitmap image
        try {
            //Establish connection
            URL aURL = new URL(imageUrl);
            URLConnection conn = aURL.openConnection();
            conn.connect();

            //Download and decode image file
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);

            bis.close();
            is.close();
        } catch (IOException e) {
            Log.e("getImageBitmap", "Error getting bitmap", e);
        }

        return bm;
    }


}
