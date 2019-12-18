package com.dicoding.picodiploma.mybottomnavigation.ui.tvshows.favtvshow;

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
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.TVShowEntity;

public class ShowPagedListAdapter extends PagedListAdapter<TVShowEntity, ShowPagedListAdapter.ShowViewHolder> {
    private final Activity activity;

    ShowPagedListAdapter(Activity activity) {
        super(DIFF_CALLBACK);
        this.activity = activity;
    }

    private static DiffUtil.ItemCallback<TVShowEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TVShowEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull TVShowEntity oldItem, @NonNull TVShowEntity newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull TVShowEntity oldItem, @NonNull TVShowEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @NonNull
    @Override
    public ShowPagedListAdapter.ShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        return new ShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowPagedListAdapter.ShowViewHolder holder, int position) {
        TVShowEntity show = getItem(position);
        Glide.with(activity.getApplicationContext())
                .load(Uri.parse(show.getPhoto()))
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvName.setText(show.getName());
        holder.tvRating.setText(show.getRating());
        holder.tvYear.setText(show.getAiredYears());
        holder.tvDesc.setText(show.getDescription());
    }

    public class ShowViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRating, tvYear, tvDesc;

        public ShowViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRating = itemView.findViewById(R.id.tv_item_rating);
            tvYear = itemView.findViewById(R.id.tv_item_year);
            tvDesc = itemView.findViewById(R.id.tv_item_desc);
        }
    }
}
