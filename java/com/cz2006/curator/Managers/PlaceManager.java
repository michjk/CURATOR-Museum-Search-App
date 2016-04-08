package com.cz2006.curator.Managers;
import com.cz2006.curator.Dialogs.GenericAlertDialog;
import com.cz2006.curator.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.places.Places;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Prasanth on 08/04/2016.
 */
public class PlaceManager extends FragmentActivity
implements OnConnectionFailedListener {
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.background_extra);

        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();
    }


    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        GenericAlertDialog genericAlertDialog = new GenericAlertDialog();
        genericAlertDialog.show(getFragmentManager(), "temp");
    }
}
