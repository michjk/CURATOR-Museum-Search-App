package com.cz2006.curator.Crawler;

import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.kml.KmlLayer;
import com.cz2006.curator.R;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by EricLeonardo on 3/30/2016.
 */
public class MuseumsCrawler extends AppCompatActivity {

    private GoogleMap gmap;
    private KmlLayer kl;

    public MuseumsCrawler(GoogleMap gmap) throws IOException, XmlPullParserException {
        this.gmap = gmap;
        kl = new KmlLayer(gmap,R.raw.museums,getApplicationContext());
    }

    public void addToMap() throws IOException, XmlPullParserException {
        kl.addLayerToMap();
    }

    public void removeFromMap(){
        kl.removeLayerFromMap();
    }

    public KmlLayer getKmlLayer(){
        return kl;
    }
}
