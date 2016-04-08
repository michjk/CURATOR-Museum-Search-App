package com.cz2006.curator.Managers;
import android.support.v4.app.FragmentActivity;


/**
 * Created by Prasanth on 08/04/2016.
 */
public class PlaceManager extends FragmentActivity
implements OnConnectionFailedListener {
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
