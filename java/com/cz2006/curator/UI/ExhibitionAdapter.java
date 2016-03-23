package com.cz2006.curator.UI;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cz2006.curator.Objects.Exhibition;
import com.cz2006.curator.R;

import java.util.List;


/**
 * Created by Acceleration on 21/03/2016.
 */
public class ExhibitionAdapter extends RecyclerView.Adapter<ExhibitionAdapter.ExhibitionViewHolder> {

    private List<Exhibition> exhibitionList;

    public ExhibitionAdapter(List<Exhibition> exhibitionList) {
        this.exhibitionList = exhibitionList;
    }

    @Override
    public int getItemCount() {
        return exhibitionList.size();
    }

    @Override
    public void onBindViewHolder(ExhibitionViewHolder exhibitionViewHolder, int i) {
        Exhibition ex = exhibitionList.get(i);
        exhibitionViewHolder.nameText.setText(ex.getName());
        exhibitionViewHolder.descriptionText.setText(ex.getDescription());

        if (ex.getImage() != null)
            Log.e("onBindViewHolder", ex.getName() + " " + String.valueOf(i));
        if (ex.getImage() != null) {
            exhibitionViewHolder.imageView.setVisibility(View.VISIBLE);
            exhibitionViewHolder.imageView.setImageBitmap(ex.getImage());
        } else {
            exhibitionViewHolder.imageView.setVisibility(View.GONE);
        }

        if (ex.getDuration() != null) {

            exhibitionViewHolder.durationText.setVisibility(View.VISIBLE);
            exhibitionViewHolder.durationText.setText(ex.getDuration());
        } else {
            exhibitionViewHolder.durationText.setVisibility(View.GONE);
        }

        if (ex.getOpeningHours() != null) {
            Log.e("getDuration", ex.getOpeningHours());
            exhibitionViewHolder.openingHoursView.setVisibility(View.VISIBLE);
            exhibitionViewHolder.openingHoursView.setText(ex.getOpeningHours());
        } else {
            exhibitionViewHolder.openingHoursView.setVisibility(View.GONE);
        }

    }

    @Override
    public ExhibitionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.exhibition_list_item, viewGroup, false);

        return new ExhibitionViewHolder(itemView);
    }

    public static class ExhibitionViewHolder extends RecyclerView.ViewHolder {

        protected TextView nameText;
        protected TextView durationText;
        protected TextView descriptionText;
        protected ImageView imageView;
        protected TextView openingHoursView;

        public ExhibitionViewHolder(View v) {
            super(v);
            nameText = (TextView) v.findViewById(R.id.name);
            durationText = (TextView) v.findViewById(R.id.duration);
            descriptionText = (TextView) v.findViewById(R.id.description);
            imageView = (ImageView) v.findViewById(R.id.image);
            openingHoursView = (TextView) v.findViewById(R.id.openingHours);
        }
    }
}
