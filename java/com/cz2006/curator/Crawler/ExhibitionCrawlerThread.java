package com.cz2006.curator.Crawler;

import android.os.AsyncTask;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by Acceleration on 21/03/2016.
 */
public class ExhibitionCrawlerThread extends AsyncTask<Void, Void, Document> {

    AsyncRespond respond;

    public ExhibitionCrawlerThread(AsyncRespond respond) {
        this.respond = respond;
    }

    @Override
    protected Document doInBackground(Void... params) {
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
                return doc;
            }
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    @Override
    protected void onPostExecute(Document document) {
        respond.processFinish(document);
    }
}
