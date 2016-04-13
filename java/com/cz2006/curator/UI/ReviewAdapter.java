package com.cz2006.curator.UI;
 
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cz2006.curator.Objects.Review;
import com.cz2006.curator.R;

import java.util.List;
 
public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {
 
    private List<Review> reviewList;
 
    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        public TextView author, date, score, text;
 
        public ReviewViewHolder(View view) {
            super(view);
            author = (TextView) view.findViewById(R.id.review_author);
            date = (TextView) view.findViewById(R.id.review_date);
            score = (TextView) view.findViewById(R.id.review_score);
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
        holder.author.setText(r.getAuthorName());
        holder.date.setText(r.getDate().toString());
        holder.score.setText(r.getRating().toString());
		holder.text.setText(r.getText());
    }
 
    @Override
    public int getItemCount() {
        return reviewList.size();
    }
}
