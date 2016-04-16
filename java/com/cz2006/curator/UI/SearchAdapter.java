package com.cz2006.curator.UI;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cz2006.curator.Objects.Museum;
import com.cz2006.curator.Objects.User;
import com.cz2006.curator.R;
import com.cz2006.curator.Managers.SearchEngine;

import java.util.ArrayList;

/**
 * Created by EricLeonardo on 3/23/2016.
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ItemViewHolder> {
    private ArrayList<Museum> museums;
    private User userLoc;

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView name_TextView;
        public TextView desc_TextView;
        public RatingBar ratingBar;
        private User userLoc;

        public ItemViewHolder(View itemView, User userLoc) {
            super(itemView);
            name_TextView = (TextView) itemView.findViewById(R.id.museum_name);
            desc_TextView = (TextView) itemView.findViewById(R.id.museum_desc);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
            this.userLoc = userLoc;
        }

        public void bind(Museum m) {
            SearchEngine.CmpByProximity getDist = new SearchEngine().new CmpByProximity();

            name_TextView.setText(m.getName());
            desc_TextView.setText(String.format("Distance: %.2f km", getDist.dist(m.getLatitude(),m.getLongitude(),userLoc.getLatitude(),userLoc.getLongitude())));
            ratingBar.setRating((float)m.getRating());
        }
    }

    public SearchAdapter(ArrayList<Museum> m, User u){
        museums = m;
        userLoc = u;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup par, int typ) {
        return new ItemViewHolder(
                LayoutInflater.from(par.getContext()).inflate(R.layout.list_row,par,false),
                userLoc
        );
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int idx) {
        holder.bind(museums.get(idx));
    }

    @Override
    public int getItemCount() {
        return museums.size();
    }

    public void setFilter(ArrayList<Museum> m) {
        museums = new ArrayList<>();
        museums.addAll(m);
        notifyDataSetChanged();
    }
}

