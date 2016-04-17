package com.cz2006.curator.UI;
 
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cz2006.curator.Objects.Review;
import com.cz2006.curator.R;

import java.util.List;

/**
 * ReviewAdapter is a class for controlling RecyclerView of list of review in ReviewUI.
 */
public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {
 
    private List<Review> reviewList;
 
    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        public TextView author, date, text;
        public RatingBar score;
        public ReviewViewHolder(View view) {
            super(view);
            author = (TextView) view.findViewById(R.id.review_author);
            date = (TextView) view.findViewById(R.id.review_date);
            score = (RatingBar) view.findViewById(R.id.review_score);
			text = (TextView) view.findViewById(R.id.review_text);
        }
    }
 
    public ReviewAdapter(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
 
    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_list_item, parent, false);
        return new ReviewViewHolder(itemView);
    }
 
    @Override
    public void onBindViewHolder(ReviewViewHolder holder, int position) {
        Review r = reviewList.get(position);
        holder.author.setText((r.getAuthorName()!=null) ? r.getAuthorName():"No author");
        holder.date.setText((r.getDate()!=null) ? r.getDate().toString():"No date");
        //holder.score.setText((r.getRating()!=null) ? "Rating: "+r.getRating().toString()+"/5.0":"No rating");
		holder.score.setRating((r.getRating()!=null)?r.getRating().floatValue():(float)0.0);
        holder.text.setText((r.getText()!=null) ? r.getText():"No text");
        Log.e("Author", holder.author.toString());
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
