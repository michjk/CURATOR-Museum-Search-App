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
import android.widget.Toast;

import com.cz2006.curator.Managers.ItemClickSupport;
import com.cz2006.curator.Managers.SearchEngine;
import com.cz2006.curator.Objects.Museum;
import com.cz2006.curator.Objects.User;
import com.cz2006.curator.R;

import java.util.ArrayList;
import java.util.List;

public class SearchUI extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private RecyclerView rv;
    private SearchAdapter adapter;
    private ArrayList<Museum> museums;
    private SearchEngine engine;
    private Context context;

    public final static String EXTRA_MESSAGE = "com.cz2006.curator.MESSAGE";

    @Override
    protected void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.activity_search);

        rv = (RecyclerView)findViewById(R.id.resultsList);
        rv.setLayoutManager(new LinearLayoutManager(this));

        User userLoc = (User) getIntent().getSerializableExtra("userLocation");
        museums = (ArrayList<Museum>) getIntent().getSerializableExtra("museumList");
        museums = (new SearchEngine(museums, userLoc)).byProximity();

        if(museums == null){
            Log.e("ERROR","museums are null");
            return;
        }
        adapter = new SearchAdapter(museums);
        rv.setAdapter(adapter);

        ItemClickSupport.addTo(rv).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent it = new Intent(getApplicationContext(),MuseumProfileUI.class);
                it.putExtra(EXTRA_MESSAGE,museums.get(position).getPlaceID());
                startActivity(it);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.search_ui_menu, menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.searchBar));
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
        return super.onOptionsItemSelected(item);
    }

    private List<Museum> filter(List<Museum> arr, String q){
        List<Museum> ret = new ArrayList<>();
        for(Museum m:arr)
            if(m.getName().toLowerCase().contains(q.toLowerCase()))
                ret.add(m);
        return ret;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.setFilter(filter(museums,newText));
        return true;
    }
}
