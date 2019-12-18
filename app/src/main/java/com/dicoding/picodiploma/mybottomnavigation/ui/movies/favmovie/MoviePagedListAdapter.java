package com.dicoding.picodiploma.mybottomnavigation.ui.movies.favmovie;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.mybottomnavigation.R;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;

public class MoviePagedListAdapter extends PagedListAdapter<MovieEntity, MoviePagedListAdapter.MovieViewHolder> {
    private final Activity activity;

    MoviePagedListAdapter(Activity activity) {
        super(DIFF_CALLBACK);
        this.activity = activity;
    }

    private static DiffUtil.ItemCallback<MovieEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MovieEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull MovieEntity oldItem, @NonNull MovieEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @NonNull
    @Override
    public MoviePagedListAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviePagedListAdapter.MovieViewHolder holder, int position) {
        MovieEntity movie = getItem(position);
        System.out.println("ID : "+movie.getId());
        System.out.println("NAME : "+movie.getName());
        System.out.println("PHOTO : "+movie.getPhoto());
        System.out.println("DESC : "+movie.getDescription());
        System.out.println("RATING : "+movie.getRating());
        System.out.println("YEAR : "+movie.getReleaseYear());
        Glide.with(activity.getApplicationContext())
                .load(Uri.parse(movie.getPhoto()))
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvName.setText(movie.getName());
        holder.tvRating.setText(movie.getRating());
        holder.tvYear.setText(movie.getReleaseYear());
        holder.tvDesc.setText(movie.getDescription());
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRating, tvYear, tvDesc;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRating = itemView.findViewById(R.id.tv_item_rating);
            tvYear = itemView.findViewById(R.id.tv_item_year);
            tvDesc = itemView.findViewById(R.id.tv_item_desc);
        }
    }
}
