package com.cz2006.curator.UI;

import android.media.Rating;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cz2006.curator.Objects.Museum;
import com.cz2006.curator.Objects.User;
import com.cz2006.curator.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EricLeonardo on 3/23/2016.
 */
public class SearchAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private List<Museum> museums;
    private User userLoc;

    public SearchAdapter(List<Museum> m, User u){
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

    public void setFilter(List<Museum> m) {
        museums = new ArrayList<>();
        museums.addAll(m);
        notifyDataSetChanged();
    }
}

class ItemViewHolder extends RecyclerView.ViewHolder {
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

    public double dist(double lat1, double lon1, double lat2, double lon2){
        double R = 6371;
        double p1 = Math.toRadians(lat1);
        double p2 = Math.toRadians(lat2);
        double dp = Math.toRadians(lat2-lat1);
        double dl = Math.toRadians(lon2-lon1);

        double a = Math.sin(dp/2.0) * Math.sin(dp/2.0)
                + Math.cos(p1/2.0) * Math.cos(p2/2.0) * Math.sin(dl/2.0) * Math.sin(dl/2.0);

        double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return R * c;
    }

    public void bind(Museum m) {
        name_TextView.setText(m.getName());
        desc_TextView.setText(String.format("Distance: %.2f km",dist(m.getLatitude(),m.getLongitude(),userLoc.getLatitude(),userLoc.getLongitude())));
        ratingBar.setRating((float)m.getRating());
    }
}