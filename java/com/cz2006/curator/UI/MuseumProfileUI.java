package com.cz2006.curator.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cz2006.curator.Constants.ExhibitionConstants;
import com.cz2006.curator.Managers.MuseumProfileManager;
import com.cz2006.curator.Objects.Museum;
import com.cz2006.curator.Objects.Review;
import com.cz2006.curator.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;

import java.util.ArrayList;

public class MuseumProfileUI extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    private final static String EXTRA_MESSAGE = "com.cz2006.curator.MESSAGE";

    private MuseumProfileManager museumProfileManager;

    private GoogleApiClient mGoogleApiClient;

    private ProgressBar spinner;

    private ArrayList<Review> reviewList;

    private ReviewAdapter rAdapter;

    private RecyclerView recyclerView;


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

        museumProfileManager = new MuseumProfileManager(museumID, mGoogleApiClient, this);

        reviewList = new ArrayList<Review>();
        recyclerView = (RecyclerView) findViewById(R.id.rr);

        LinearLayoutManager rLayoutManager = new LinearLayoutManager(getApplicationContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(rLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        rAdapter = new ReviewAdapter(reviewList);
        recyclerView.setAdapter(rAdapter);
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
        String message = museumProfileManager.getMuseum().getName();
        // this message means nothing for now
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
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

            for (Review r: museum.getReviewList()) {
                reviewList.add(r);
                Log.e("Review Debug", r.getAuthorName());
            }
            rAdapter.notifyDataSetChanged();
            recyclerView.invalidate();

            //removes loading spinner
            spinner.setVisibility(View.GONE);
        }
    }
}
