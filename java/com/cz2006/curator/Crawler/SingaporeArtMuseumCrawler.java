package com.cz2006.curator.Crawler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cz2006.curator.Objects.Exhibition;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
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
    @Override
    protected Void doInBackground(Void... params) {
        try {
            //Establish connection to exhibition page
            Connection con = Jsoup
                    .connect("https://www.singaporeartmuseum.sg/exhibitions/current.html")
                    .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                    .timeout(10000);
            Connection.Response resp = con.execute();

            //Crawl if successful
            if(resp.statusCode() == 200) {
                //Get exhibition section from the page
                Document doc = con.get();
                Log.e("success singapore", "success");
                extractExhibition(doc);
            }
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }


    protected void extractExhibition (Object document) {
        Object elements = ((Document)document).select("article");
        //Reset list
        exhibitionList.clear();

        //Process each section
        for (Element e: (Elements)elements) {
            Exhibition exhibition = new Exhibition(getName(e), getOrganizer(e), getOpeningHours(e),
            getFees(e), getRestriction(e), getDuration(e), getDescription(e), getImage(e), getTicketSite(e));
            exhibitionList.add(exhibition);
        }
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        ((RecyclerView.Adapter)adapter).notifyDataSetChanged();
    }

    protected String getName(Object element) {
        Log.e("getName", ((Element)element).select(".MainTitle").text());
        return ((Element)element).select(".MainTitle").text();
    }

    protected String getDuration(Object element) {
        return ((Element)element).select("p strong").get(0).text();
    }

    protected String getDescription(Object element) {
        Elements content = ((Element)element).select("div.col-left");
        if(content.size() == 0)
            content = ((Element)element).select("div[style=float:left; width:380px; ]");
        if(content.size() == 0)
            content = ((Element)element).select("div[style=float:right; width:470px; ]");
        if(content.size() == 0)
            content = ((Element)element).select("div p span");

        return content.text();
    }

    protected Bitmap getImage(Object element) {

        //Get a container where img tag is located
        Elements imageTag =((Element)element).select(".col-right");
        if(imageTag.size()==0)
            imageTag =  ((Element)element).select("div[style=float:right; margin:10px 0px 0px 20px; width:350px; ]");
        if(imageTag.size()==0)
            imageTag = ((Element)element).select("div[style=float:right; margin:0px 0px 0px 0px; width:350px; ]");
        if(imageTag.size()==0)
            imageTag = ((Element)element).select("div[style=float:left; margin:20px 20px 0px 0px; width:260px; ]");

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
