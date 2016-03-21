package com.cz2006.curator.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.cz2006.curator.Managers.SearchManager;
import com.cz2006.curator.Objects.Museum;
import com.cz2006.curator.R;

import java.util.ArrayList;

/**
 * Created by EricLeonardo on 3/22/2016.
 */
public class SearchUI extends AppCompatActivity {
    private String request = "";
    private Integer listingType = 0;
    private ListView museumListView;
    private SearchManager searchManager;

    @Override
    protected void onCreate(Bundle saved){
        super.onCreate(saved);
        //TODO: setContentView(R.layout.activity_search);
    }

    protected void displaySearchBar(){

    }

    /**
     * TODO
     * The function updates the search UI with the given search results
     * @param results search result
     */
    void updateResults(ArrayList<Museum> results){

    }
}
