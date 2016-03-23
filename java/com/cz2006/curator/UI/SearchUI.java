package com.cz2006.curator.UI;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

//import com.cz2006.curator.Managers.SearchManager;
import com.cz2006.curator.Objects.Museum;
import com.cz2006.curator.R;

import java.util.ArrayList;

/**
 * Created by EricLeonardo on 3/22/2016.
 */
public class SearchUI extends AppCompatActivity{
    private String request = "";
    private Integer listingType = 0;
    private ListView museumListView;
    private SearchManager searchManager;

    private EditText inputText;

    @Override
    protected void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.activity_search);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //searchManager = new SearchManager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.search_ui_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.searchBar).getActionView();

        if(searchView != null){
            searchView.setIconifiedByDefault(false);
        }
        return true;
    }

    /*
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText){
        return false;
    }
    */

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * TODO
     * The function updates the search UI with the given search results
     * @param results search result
     */
    void updateResults(ArrayList<Museum> results){

    }
}
