package com.cz2006.curator.Crawler;

import android.support.v7.widget.RecyclerView;

import com.cz2006.curator.Objects.Exhibition;

import java.util.ArrayList;

/**
 * Created by Acceleration on 20/03/2016.
 */
public interface ExhibitionCrawlerInterface {
    public void refresh();
    public void setAdapter(RecyclerView.Adapter adapter);
    public void setExhibitionList(ArrayList<Exhibition> exhibitionList);
}
