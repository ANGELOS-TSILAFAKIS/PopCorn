package com.hitanshudhawan.popcorn.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hitanshudhawan.popcorn.R;
import com.hitanshudhawan.popcorn.network.movies.Cast;

import java.util.List;

/**
 * Created by hitanshu on 2/8/17.
 */

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    Context mContext;
    List<Cast> mCasts;

    public CastAdapter(Context mContext, List<Cast> mCasts) {
        this.mContext = mContext;
        this.mCasts = mCasts;
    }

    @Override
    public CastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CastAdapter.CastViewHolder(LayoutInflater.from(mContext).inflate(R.layout.cast_item,parent,false));
    }

    @Override
    public void onBindViewHolder(CastViewHolder holder, int position) {

        Glide.with(mContext).load("https://image.tmdb.org/t/p/w1000/" + mCasts.get(position).getProfilePath())
                .asBitmap()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.castImageView);

        holder.nameTextView.setText(mCasts.get(position).getName());
        holder.characterTextView.setText(mCasts.get(position).getCharacter());

    }

    @Override
    public int getItemCount() {
        return mCasts.size();
    }



    public class CastViewHolder extends RecyclerView.ViewHolder {

        public ImageView castImageView;
        public TextView nameTextView;
        public TextView characterTextView;

        public CastViewHolder(View itemView) {
            super(itemView);
            castImageView = (ImageView) itemView.findViewById(R.id.imageview_cast);
            nameTextView = (TextView) itemView.findViewById(R.id.textview_cast_name);
            characterTextView = (TextView) itemView.findViewById(R.id.textview_cast_as);
        }
    }

}