package com.cz2006.curator.UI;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.cz2006.curator.Objects.Museum;
import com.cz2006.curator.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EricLeonardo on 3/23/2016.
 */
public class SearchAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private List<Museum> museums;

    public SearchAdapter(List<Museum> m){
        museums = m;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup par, int typ) {
        return new ItemViewHolder(
                LayoutInflater.from(par.getContext()).inflate(R.layout.list_row,par,false)
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

    public ItemViewHolder(View itemView) {
        super(itemView);
        name_TextView = (TextView) itemView.findViewById(R.id.museum_name);
        desc_TextView = (TextView) itemView.findViewById(R.id.museum_desc);
    }

    public void bind(Museum m) {
        name_TextView.setText(m.getName());
        desc_TextView.setText(m.getDescription());
    }
}