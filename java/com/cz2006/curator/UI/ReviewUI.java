package com.cz2006.curator.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;


import com.cz2006.curator.Objects.Review;
import com.cz2006.curator.R;

import java.util.ArrayList;

public class ReviewUI extends AppCompatActivity {

    private RecyclerView rv;
    private LinearLayoutManager llm;
    private ArrayList<Review> reviewList;
    private ReviewAdapter radapter;
    private String museumName;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.review_activity);
        reviewList = (ArrayList<Review>)getIntent().getSerializableExtra("reviews");

        for(Review r:reviewList){
            Log.e("author", r.getAuthorName());
        }

        rv = (RecyclerView) findViewById(R.id.rr);

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);

        radapter = new ReviewAdapter(reviewList);
        rv.setAdapter(radapter);
    }


}
