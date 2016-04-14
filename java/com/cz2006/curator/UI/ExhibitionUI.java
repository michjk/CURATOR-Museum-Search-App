package com.cz2006.curator.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.cz2006.curator.Managers.ExhibitionManager;
import com.cz2006.curator.Objects.Exhibition;
import com.cz2006.curator.R;

import java.util.ArrayList;

public class ExhibitionUI extends AppCompatActivity {

    private RecyclerView rv;
    private LinearLayoutManager llm;
    private ArrayList<Exhibition> exhibitionList;
    private ExhibitionAdapter adapter;
    private String museumName;
    private ExhibitionManager exhibitionManager;
    private ProgressBar spinner;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //display a loading spinner while data loads
        spinner = (ProgressBar)findViewById(R.id.progressBar2);
        spinner.setVisibility(View.VISIBLE);
        setContentView(R.layout.activity_exhibition_ui);

        rv = (RecyclerView) findViewById(R.id.rv);

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);


        exhibitionList = new ArrayList<>();
        adapter = new ExhibitionAdapter(exhibitionList);
        rv.setAdapter(adapter);

        exhibitionManager = new ExhibitionManager(exhibitionList, adapter, this);
        spinner.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        exhibitionManager.refresh();
    }
}
