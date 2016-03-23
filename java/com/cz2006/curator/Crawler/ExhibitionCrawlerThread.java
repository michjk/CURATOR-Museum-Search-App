package com.cz2006.curator.Crawler;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by Acceleration on 21/03/2016.
 */
public class ExhibitionCrawlerThread extends AsyncTask<Void, Void, Object> {

    AsyncRespond respond;

    public ExhibitionCrawlerThread(AsyncRespond respond) {
        this.respond = respond;
    }

    @Override
    protected Object doInBackground(Void... params) {
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
                Log.e("success", "success");
                return doc;
            }
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    @Override
    protected void onPostExecute(Object document) {
        respond.processFinish(document);
    }
}
