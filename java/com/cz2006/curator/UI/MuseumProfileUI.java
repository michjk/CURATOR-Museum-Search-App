package com.cz2006.curator.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.cz2006.curator.Constants.ExhibitionConstants;
import com.cz2006.curator.Managers.MuseumProfileManager;
import com.cz2006.curator.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;

public class MuseumProfileUI extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    private final static String EXTRA_MESSAGE = "com.cz2006.curator.MESSAGE";

    private MuseumProfileManager museumProfileManager;

    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_profile_ui);

        String museumName = getIntent().getStringExtra(EXTRA_MESSAGE);
        TextView title = (TextView) findViewById(R.id.museum_name);
        title.setText(museumName);

        ExhibitionConstants.setExhibitionConstants(this);

        String placeId = "ChIJW8o1nqQZ2jERynZN2M1BODM";

        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();


        museumProfileManager = new MuseumProfileManager(placeId, mGoogleApiClient);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e("MuseumProfileUI", connectionResult.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        museumProfileManager.refresh();

    }

    public void onClickExhibition(View view) {
        // listener for the Exhibition button



        Intent intent = new Intent(this, ExhibitionUI.class);
        String message = "Singapore Art Museum";
        // this message means nothing for now
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
