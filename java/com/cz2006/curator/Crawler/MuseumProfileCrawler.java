package com.cz2006.curator.Crawler;

import android.os.AsyncTask;
import android.util.Log;

import com.cz2006.curator.Constants.MuseumConstants;
import com.cz2006.curator.Objects.Museum;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Acceleration on 09/04/2016.
 */
public class MuseumProfileCrawler extends AsyncTask<String, Void, ArrayList<Museum>> implements MuseumProfileCrawlerInterface {

    public AsyncRespond asyncRespond;
    private String placeId;

    public MuseumProfileCrawler(String placeId, AsyncRespond asyncRespond) {
        this.asyncRespond = asyncRespond;
        this.placeId = placeId;
    }

    @Override
    public void refresh() {
        this.execute(MuseumConstants.URL + placeId);
    }

    @Override
    protected ArrayList<Museum> doInBackground(String... params) {

        String jsonStr = getJSONFromUrl(params[0]);

        JSONObject jsonObject = null;
        JSONObject result = null;
        String address = null;
        String phone = null;
        Double rating = null;
        String name = null;
        JSONObject openingHoursObject = null;
        JSONArray weekdayText = null;
        ArrayList<String> openingHours = null;


        if(jsonStr != null) {
            Log.e("MuseumProfileCrawler", jsonStr);
            try {
                jsonObject = new JSONObject(jsonStr);
                result = jsonObject.getJSONObject("result");
                address = result.getString("formatted_address");
                phone = result.getString("formatted_phone_number");
                rating = result.getDouble("rating");
                name = result.getString("name");
                openingHoursObject = result.getJSONObject("opening_hours");
                weekdayText = result.getJSONArray("weekday_text");
                openingHours = new ArrayList<>();

                for(int i = 0; i < weekdayText.length(); i++) {
                    openingHours.add(weekdayText.getString(i));
                }



                Log.e("MuseumProfileCrawler", name);
                Log.e("MuseumProfileCrawler", address);
                Log.e("MuseumProfileCrawler", phone);
                Log.e("MuseumProfileCrawler", rating + "");
                Log.e("MuseumProfileCrawler", openingHours.toString());

            }catch(JSONException e) {
                Log.e("MuseumProfileError", e.getMessage());
            }

        }

        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Museum> musea) {
        super.onPostExecute(musea);
    }

    public String getJSONFromUrl(String add) {

        String json = null;
        StringBuffer sb = new StringBuffer();
        InputStream is = null;

        try {
            // defaultHttpClient
            URL url = new URL(add);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.getResponseCode();

            is = new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String inputLine = "";

            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }

            json = sb.toString();

        } catch (UnsupportedEncodingException e) {
            Log.e("MuseumProfileCrawler", e.getMessage());
        } catch (IOException e) {
            Log.e("MuseumProfileCrawler", e.getMessage());
        } catch (Exception e) {
            Log.e("MuseumProfileCrawler", e.getMessage());
        }
        // return json
        return json;
    }
}
