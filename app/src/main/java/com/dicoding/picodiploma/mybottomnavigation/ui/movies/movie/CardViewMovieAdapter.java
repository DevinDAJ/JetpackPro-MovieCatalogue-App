package com.dicoding.picodiploma.mybottomnavigation.ui.movies.movie;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.mybottomnavigation.R;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;

import java.util.ArrayList;

public class CardViewMovieAdapter extends RecyclerView.Adapter<CardViewMovieAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<MovieEntity> listMovies;
    private ArrayList<MovieEntity> getListMovies() {
        return listMovies;
    }

    public void setListMovies(ArrayList<MovieEntity> mListMovies) {
        this.listMovies = mListMovies;
    }

    public CardViewMovieAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, int i) {
        Glide.with(context)
                .load(Uri.parse(getListMovies().get(i).getPhoto()))
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);
        cardViewViewHolder.tvName.setText(getListMovies().get(i).getName());
        cardViewViewHolder.tvRating.setText(getListMovies().get(i).getRating());
        cardViewViewHolder.tvYear.setText(getListMovies().get(i).getReleaseYear());
        cardViewViewHolder.tvDesc.setText(getListMovies().get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return getListMovies().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRating, tvYear, tvDesc;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRating = itemView.findViewById(R.id.tv_item_rating);
            tvYear = itemView.findViewById(R.id.tv_item_year);
            tvDesc = itemView.findViewById(R.id.tv_item_desc);
        }
    }
}
