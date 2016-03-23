package com.cz2006.curator.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cz2006.curator.Crawler.ExhibitionCrawlerInterface;
import com.cz2006.curator.Crawler.SingaporeArtMuseumCrawler;
import com.cz2006.curator.Objects.Exhibition;
import com.cz2006.curator.R;

import java.util.ArrayList;

public class ExhibitionUI extends AppCompatActivity {

    private RecyclerView rv;
    private LinearLayoutManager llm;
    private ArrayList<Exhibition> exhibitionList;
    private ExhibitionAdapter adapter;
    private ExhibitionCrawlerInterface crawler;
    private String museumName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibition_ui);

        rv = (RecyclerView)findViewById(R.id.rv);

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);


        exhibitionList = new ArrayList<>();
        adapter = new ExhibitionAdapter(exhibitionList);
        rv.setAdapter(adapter);

        museumName = "Singapore Art Museum";

        crawler = new SingaporeArtMuseumCrawler();
        crawler.setAdapter(adapter);
        crawler.setExhibitionList(exhibitionList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        crawler.refresh();
    }
}
