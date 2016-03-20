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
import java.util.ArrayList;

/**
 * Created by Acceleration on 21/03/2016.
 */
public class SingaporeArtMuseumCrawler extends ExhibitionFormatTemplate {

    public SingaporeArtMuseumCrawler(RecyclerView recyclerView) {
        super(recyclerView);
    }

    @Override
    public ArrayList<Exhibition> getExhibitionList() {
        return null;
    }

    @Override
    protected ArrayList<Exhibition> doInBackground(Void... params) {
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
                Elements news = doc.select("article");

                //Process each section
                for (Element e: news) {
                    String mainTitle = getName(e);
                    String duration = getDuration(e);
                    String description = getDescription(e);
                    Bitmap image = getImage(e);
                    String restriction = null;

                    exhibitionList.add(null);
                }

            }
        }catch(Exception e) {
            e.printStackTrace();
        }

        return exhibitionList;
    }

    private String getName(Element element) {
        return element.select(".MainTitle").text();
    }

    private String getDuration(Element element) {
        return element.select("p strong").get(0).text();
    }

    private String getDescription(Element element) {
        Elements content = element.select("div.col-left");
        if(content.size() == 0)
            content = element.select("div[style=float:left; width:380px; ]");
        if(content.size() == 0)
            content = element.select("div[style=float:right; width:470px; ]");
        if(content.size() == 0)
            content = element.select("div p span");

        return content.text();
    }

    private Bitmap getImage(Element element) {

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

    @Override
    protected void onPostExecute(ArrayList<Exhibition> exhibitions) {

    }

}
