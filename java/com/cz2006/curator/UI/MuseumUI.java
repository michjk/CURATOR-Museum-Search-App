package com.cz2006.curator.UI;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cz2006.curator.Constants.ExhibitionConstants;
import com.cz2006.curator.Managers.MuseumManager;
import com.cz2006.curator.Objects.Museum;
import com.cz2006.curator.Objects.Review;
import com.cz2006.curator.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;

import java.util.ArrayList;

public class MuseumUI extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    private final static String EXTRA_MESSAGE = "com.cz2006.curator.MESSAGE";

    private MuseumManager museumManager;

    private GoogleApiClient mGoogleApiClient;

    private ProgressBar spinner;

    private ArrayList<Review> reviewList;

    private Button reviewButton;

    private Button exhibitionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_profile_ui);
        String museumID = getIntent().getStringExtra(EXTRA_MESSAGE);
        ExhibitionConstants.setExhibitionConstants(this);

        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();

        museumManager = new MuseumManager(museumID, mGoogleApiClient, this);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e("MuseumUI", connectionResult.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        //museumManager.getMuseum().toString()
        museumManager.refresh();
    }

    public void onClickExhibition(View view) {
        // listener for the Exhibition button
        Intent intent = new Intent(this, ExhibitionUI.class);
        String message = museumManager.getMuseum().getName();
        // this message means nothing for now
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void onClickReview(View view) {
        // listener for the Review button
        Intent intent = new Intent(this, ReviewUI.class);
        // this message means nothing for now
        intent.putExtra("reviews", reviewList);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayData(Museum museum) {

        String openingHourList = "Opening Hours: \n";
        //display a loading spinner while data loads
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.VISIBLE);

        if (museum != null) {
            TextView title = (TextView) findViewById(R.id.museum_name);
            title.setText(museum.getName());

            ImageView image = (ImageView) findViewById(R.id.image);
            image.setImageBitmap(museum.getImage());

            TextView address = (TextView) findViewById(R.id.address);
            address.setText("Address: " + museum.getAddress());

            TextView openingHours = (TextView) findViewById(R.id.opening_hours);
            for(String o :museum.getOpeningHours()) {
                openingHourList = openingHourList + o + "\n";
            }
            openingHours.setText(openingHourList);

            TextView phoneNo = (TextView) findViewById(R.id.phone);
            phoneNo.setText("Phone No.: " + museum.getPhone());

            TextView website = (TextView) findViewById(R.id.website);
            website.setText("Website: " + museum.getTicketSite());

            reviewList = museum.getReviewList();

            exhibitionButton = (Button)findViewById(R.id.exhibit_button);
            exhibitionButton.setClickable(false);
            exhibitionButton.setTextColor(Color.parseColor("grey"));

            reviewButton = (Button)findViewById(R.id.review_button);
            reviewButton.setClickable(false);
            reviewButton.setTextColor(Color.parseColor("grey"));

            ExhibitionConstants.setExhibitionConstants(this);
            if(ExhibitionConstants.exhibitionClass.containsKey(museum.getName())) {
                exhibitionButton.setClickable(true);
                exhibitionButton.setTextColor(Color.parseColor("black"));
            }

            if(!reviewList.isEmpty()) {
                reviewButton.setClickable(true);
                reviewButton.setTextColor(Color.parseColor("black"));
            }

            //removes loading spinner
            spinner.setVisibility(View.GONE);
        }
    }
}
