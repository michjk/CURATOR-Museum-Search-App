package com.cz2006.curator.Crawler;

import android.os.AsyncTask;
import android.util.Log;

import com.cz2006.curator.Constants.PlaceConstants;
import com.cz2006.curator.Objects.Place;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Acceleration on 08/04/2016.
 */
public class PlaceCrawler extends AsyncTask<String, Void, ArrayList<Place>> implements PlaceCrawlerInterface {

    public AsyncRespond asyncRespond;

    public PlaceCrawler(AsyncRespond asyncRespond) {
        this.asyncRespond = asyncRespond;
    }

    @Override
    public void refresh() {
        this.execute(PlaceConstants.URL);
    }

    @Override
    protected ArrayList<Place> doInBackground(String... params) {

        String xml = getXmlFromUrl(params[0]);

        Document doc = getDomElement(xml);

        NodeList nl = doc.getElementsByTagName(PlaceConstants.KEY_ITEM);

        ArrayList<Place> placeList = new ArrayList<>();

        // looping through all item nodes <item>
        for (int i = 0; i < nl.getLength(); i++) {
            Element e = (Element) nl.item(i);

            //Log.e("COba", getValue(e, PlaceConstants.KEY_RATING));

            Double rating = null;
            try {
                rating = Double.parseDouble(getValue(e, PlaceConstants.KEY_RATING));
            } catch(NumberFormatException er) {
                rating =  0.0;
            }

            Log.e("COba", rating+"");


            Place place = new Place(getValue(e, PlaceConstants.KEY_NAME)
                    , getValue(e,"formatted_address")
                    , Double.parseDouble(getValue(e, PlaceConstants.KEY_LAT))
                    , Double.parseDouble(getValue(e, PlaceConstants.KEY_LNG))
                    , rating
                    , getValue(e, PlaceConstants.KEY_ID));

            placeList.add(place);
        }
        return placeList;
    }

    @Override
    protected void onPostExecute(ArrayList<Place> places) {
        asyncRespond.processFinish(places);
    }

    public String getXmlFromUrl(String add) {

        String xml = null;
        StringBuffer sb = new StringBuffer();
        InputStream is = null;

        try {
            // defaultHttpClient
            URL url = new URL(add);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            Log.e("PlaceCrawler", "" + httpURLConnection.getResponseCode());
            httpURLConnection.getResponseCode();

            is = new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String inputLine = "";

            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }

            xml = sb.toString();

        } catch (UnsupportedEncodingException e) {
            Log.e("PlaceCrawler", e.getMessage());
        } catch (IOException e) {
            Log.e("PlaceCrawler", e.getMessage());
        } catch (Exception e) {
            Log.e("PlaceCrawler", e.getMessage());
        }
        // return XML
        return xml;
    }

    public Document getDomElement(String xml){
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();

            InputSource is = new InputSource();

            Log.e("test", xml);

            is.setCharacterStream(new StringReader(xml));
            doc = db.parse(is);

        } catch (ParserConfigurationException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (SAXException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (IOException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        }
        // return DOM
        return doc;
    }

    public String getValue(Element item, String str) {
        NodeList n = item.getElementsByTagName(str);
        return this.getElementValue(n.item(0));
    }

    public final String getElementValue( Node elem ) {
        Node child;
        if( elem != null){
            if (elem.hasChildNodes()){
                for( child = elem.getFirstChild(); child != null; child = child.getNextSibling() ){
                    if( child.getNodeType() == Node.TEXT_NODE  ){
                        return child.getNodeValue();
                    }
                }
            }
        }
        return "";
    }

}
