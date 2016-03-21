package com.cz2006.curator.Crawler;

import android.graphics.Bitmap;
import android.os.AsyncTask;

/**
 * Created by Acceleration on 22/03/2016.
 */
public class BitmapCrawler extends AsyncTask<Void, Void, Bitmap> {

    AsyncRespond respond;

    public BitmapCrawler(AsyncRespond respond) {
        this.respond = respond;
    }

    @Override
    protected Bitmap doInBackground(Void... params) {

        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
    }
}
