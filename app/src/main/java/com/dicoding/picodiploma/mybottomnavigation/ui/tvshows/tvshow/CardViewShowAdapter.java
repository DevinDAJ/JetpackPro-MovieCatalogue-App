package com.dicoding.picodiploma.mybottomnavigation.ui.tvshows.tvshow;

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
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.TVShowEntity;
import java.util.ArrayList;

public class CardViewShowAdapter extends RecyclerView.Adapter<CardViewShowAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<TVShowEntity> listShows;
    private ArrayList<TVShowEntity> getListShows() {
        return listShows;
    }

    public void setListShows(ArrayList<TVShowEntity> listShows) {
        this.listShows = listShows;
    }

    public CardViewShowAdapter(Context context) {
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
                .load(Uri.parse(getListShows().get(i).getPhoto()))
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);
        cardViewViewHolder.tvName.setText(getListShows().get(i).getName());
        cardViewViewHolder.tvRating.setText(getListShows().get(i).getRating());
        cardViewViewHolder.tvYear.setText(getListShows().get(i).getAiredYears());
        cardViewViewHolder.tvDesc.setText(getListShows().get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return getListShows().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
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
