package com.hitanshudhawan.popcorn.movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hitanshudhawan.popcorn.R;
import com.hitanshudhawan.popcorn.network.movies.MovieBrief;

import java.util.List;

/**
 * Created by hitanshu on 31/7/17.
 */

public class MoviesSmallAdapter extends RecyclerView.Adapter<MoviesSmallAdapter.MoviesViewHolder> {

    Context mContext;
    List<MovieBrief> mMovies;

    public MoviesSmallAdapter(Context context, List<MovieBrief> movies) {
        mContext = context;
        mMovies = movies;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MoviesViewHolder(LayoutInflater.from(mContext).inflate(R.layout.card_movie_small,parent,false));
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        Glide.with(mContext).load("https://image.tmdb.org/t/p/w780/" + mMovies.get(position).getPosterPath())
                .asBitmap()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.moviePosterImageView);
        holder.movieTitleTextView.setText(mMovies.get(position).getTitle());
        //holder.movieFavImageButton.setOnClickListener();
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder {

        public ImageView moviePosterImageView;
        public TextView movieTitleTextView;
        public ImageButton movieFavImageButton;


        public MoviesViewHolder(View itemView) {
            super(itemView);
            moviePosterImageView = (ImageView) itemView.findViewById(R.id.imageview_movie_card);
            movieTitleTextView = (TextView) itemView.findViewById(R.id.textview_title_movie_card);
            movieFavImageButton = (ImageButton) itemView.findViewById(R.id.imagebutton_fav_movie_card);
        }
    }

}