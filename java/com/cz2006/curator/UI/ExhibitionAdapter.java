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
        exhibitionViewHolder.titleText.setText(ex.getName());
        exhibitionViewHolder.scheduleText.setText(ex.getDuration());
        exhibitionViewHolder.contentText.setText(ex.getDescription());
        if (ex.getImage() != null)
            Log.e("onBindViewHolder", ex.getName() + " " + String.valueOf(i));
        if (ex.getImage() != null) {
            exhibitionViewHolder.imageView.setVisibility(View.VISIBLE);
            exhibitionViewHolder.imageView.setImageBitmap(ex.getImage());
        } else {
            exhibitionViewHolder.imageView.setVisibility(View.GONE);
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

        protected TextView titleText;
        protected TextView scheduleText;
        protected TextView contentText;
        protected ImageView imageView;

        public ExhibitionViewHolder(View v) {
            super(v);
            titleText = (TextView) v.findViewById(R.id.title);
            scheduleText = (TextView) v.findViewById(R.id.schedule);
            contentText = (TextView) v.findViewById(R.id.content);
            imageView = (ImageView) v.findViewById(R.id.image);
        }
    }
}
