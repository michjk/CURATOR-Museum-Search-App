package com.cz2006.curator.UI;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cz2006.curator.Dialogs.GenericAlertDialog;
import com.cz2006.curator.Managers.ItemClickSupport;
import com.cz2006.curator.Managers.SearchEngine;
import com.cz2006.curator.Objects.Museum;
import com.cz2006.curator.Objects.User;
import com.cz2006.curator.R;

import java.util.ArrayList;

/**
 * SearchUI is a boundary class that display list of museum and providing interface to use search filter
 * and sorting by proximity or by rating. This class is managed by SearchManager.
 */
public class SearchUI extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private RecyclerView rv;
    private SearchAdapter adapter;
    private ArrayList<Museum> museums;
    private User userLoc;
    private SearchView searchView;

    public final static String EXTRA_MESSAGE = "com.cz2006.curator.MESSAGE";

    @Override
    protected void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.activity_search);

        rv = (RecyclerView)findViewById(R.id.resultsList);
        rv.setLayoutManager(new LinearLayoutManager(this));

        userLoc = (User) getIntent().getSerializableExtra("userLocation");
        museums = (ArrayList<Museum>) getIntent().getSerializableExtra("museumList");
        //museums = (new SearchEngine(museums, userLoc)).byProximity();
        updateView();
    }

    public void updateView(){
        if(museums == null){
            Log.e("ERROR","museums are null");
            GenericAlertDialog genericAlertDialog = new GenericAlertDialog();
            genericAlertDialog.show(getFragmentManager(), "No museums found, try again!");
            return;
        }
        adapter = new SearchAdapter(museums,userLoc);
        rv.setAdapter(adapter);

        ItemClickSupport.addTo(rv).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                TextView tv = (TextView)v.findViewById(R.id.museum_name);
                String name = tv.getText().toString();
                String id = "";
                for(Museum m:museums){
                    if(m.getName().compareTo(name) == 0){
                        id = m.getPlaceID();
                        break;
                    }
                }
                Intent it = new Intent(getApplicationContext(),MuseumUI.class);
                it.putExtra(EXTRA_MESSAGE,id);
                startActivity(it);
            }
        });
    }

    public void updateView(String q){
        if(museums == null){
            Log.e("ERROR","museums are null");
            GenericAlertDialog genericAlertDialog = new GenericAlertDialog();
            genericAlertDialog.show(getFragmentManager(), "No museums found, try again!");
            return;
        }
        adapter = new SearchAdapter(new SearchEngine().filter(museums, q),userLoc);
        rv.setAdapter(adapter);

        ItemClickSupport.addTo(rv).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                TextView tv = (TextView)v.findViewById(R.id.museum_name);
                String name = tv.getText().toString();
                String id = "";
                for(Museum m:museums){
                    if(m.getName().compareTo(name) == 0){
                        id = m.getPlaceID();
                        break;
                    }
                }
                Intent it = new Intent(getApplicationContext(),MuseumUI.class);
                it.putExtra(EXTRA_MESSAGE,id);
                startActivity(it);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.search_ui_menu, menu);
        searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.searchBar));
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        if(searchView == null){
            Toast.makeText(this,"Null search view",Toast.LENGTH_LONG);
            return true;
        }

        if(searchManager == null){
            Toast.makeText(this,"Null search manager",Toast.LENGTH_LONG);
            return true;
        }

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.requestFocus();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_search) {
            return true;
        }
        else if(id == R.id.sortByProximity){
            museums = (new SearchEngine(museums, userLoc)).byProximity();
            //adapter.setFilter(filter(museums, searchView.getQuery().toString()));
            updateView(searchView.getQuery().toString());
        }
        else{
            museums = (new SearchEngine(museums, userLoc)).byRating();
            //adapter.setFilter(filter(museums, searchView.getQuery().toString()));
            updateView(searchView.getQuery().toString());
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.setFilter(new SearchEngine().filter(museums, newText));
        return true;
    }

}
