package com.cz2006.curator.Managers;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.cz2006.curator.R;
import com.google.android.gms.common.api.GoogleApiClient;


/**
 * Created by Prasanth on 08/04/2016.
 */
public class PlaceManager extends FragmentActivity
implements GoogleApiClient.OnConnectionFailedListener {
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate (Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity.activity_main);

        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();
    }
    private void OnConnectionFailedListener() {
        
    }
}
