package com.dicoding.picodiploma.mybottomnavigation.ui.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.mybottomnavigation.R;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.LocalRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.FaveEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.TVShowEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.room.FaveDatabase;
import com.dicoding.picodiploma.mybottomnavigation.utils.DataDummy;
import com.dicoding.picodiploma.mybottomnavigation.viewmodel.ViewModelFactory;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_MOVIE = "extra_movie";
    DetailViewModel viewModel;
    private LocalRepository localRepository;
    FaveDatabase db;
    private ImageView imgPhoto, imgLove;
    private TextView tvName, tvDesc, tvRating, tvYear;
    private Boolean heartState = false;
    private int movieOrShow = 0; // 0 for movie and 1 for show
    private MovieEntity movie;
    private TVShowEntity show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        db = FaveDatabase.getInstance(getApplication());
        localRepository = new LocalRepository(db.faveDao());
        viewModel = obtainViewModel(DetailActivity.this);
        initViews();
        imgLove.setOnClickListener(this);
        Intent intent = getIntent();
        if(intent.getParcelableExtra("MOVIE") != null) {
            movie = intent.getParcelableExtra("MOVIE");
            movieOrShow = 0;
            viewModel.setMovieId(movie.getId());
            if(localRepository.checkEntity(movie.getId(), 0)) {
                imgLove.setImageDrawable(getDrawable(R.drawable.love_on_46));
                heartState = true;
            } else {
                imgLove.setImageDrawable(getDrawable(R.drawable.love_off_46));
                heartState = false;
            }
            viewModel.fecthMovie().observe(this, mMovie -> {
                MovieEntity mov = DataDummy.generateDummyMovies().get(0);
                String mPhoto = mov.getPhoto();
                String mName = mov.getName();
                String mDesc = mov.getDescription();
                String mRating = mov.getRating();
                String mYear = mov.getReleaseYear();
                if(mMovie.getPhoto() != null) {
                    mPhoto = mMovie.getPhoto();
                    mName = mMovie.getName();
                    mDesc = mMovie.getDescription();
                    mRating = mMovie.getRating();
                    mYear = mMovie.getReleaseYear();
                }
                Glide.with(this)
                        .load(Uri.parse(mPhoto))
                        .apply(new RequestOptions().override(350, 350))
                        .into(imgPhoto);
                tvName.setText(mName);
                tvDesc.setText(mDesc);
                tvRating.setText(mRating);
                tvYear.setText(mYear);
            });
        }
        else if(intent.getParcelableExtra("SHOW") != null) {
            show = intent.getParcelableExtra("SHOW");
            movieOrShow = 1;
            viewModel.setTvshowId(show.getId());
            if(localRepository.checkEntity(show.getId(), 1)) {
                imgLove.setImageDrawable(getDrawable(R.drawable.love_on_46));
            } else {
                imgLove.setImageDrawable(getDrawable(R.drawable.love_off_46));
            }
            viewModel.fetchShow().observe(this, sShow -> {
                Glide.with(this)
                        .load(Uri.parse(sShow.getPhoto()))
                        .apply(new RequestOptions().override(350, 350))
                        .into(imgPhoto);
                tvName.setText(sShow.getName());
                tvDesc.setText(sShow.getDescription());
                tvRating.setText(sShow.getRating());
                tvYear.setText(sShow.getAiredYears());
            });
        }
    }

    private void initViews() {
        imgPhoto = findViewById(R.id.img_item_photo);
        imgLove = findViewById(R.id.img_love);
        tvName = findViewById(R.id.tv_item_name);
        tvDesc = findViewById(R.id.tv_item_desc);
        tvRating = findViewById(R.id.tv_item_rating);
        tvYear = findViewById(R.id.tv_item_year);
    }

    @NonNull
    private static DetailViewModel obtainViewModel(AppCompatActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(DetailViewModel.class);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.img_love) {
            if(movieOrShow == 0) {
                if(heartState) {
                    FaveEntity entity = new FaveEntity(movie.getId(),
                            movie.getPhoto(), movie.getName(), movie.getDescription(),
                            movie.getRating(), movie.getReleaseYear(), 0);
                    int result = localRepository.delete(entity);
                    System.out.println("movieOrShow : " + movieOrShow + " | heartState : " + heartState + " | result : " + result);
                    if(result > 0) {
                        Toast.makeText(this, "Film telah dihapus dari daftar Favorit", Toast.LENGTH_SHORT).show();
                        heartState = false;
                        imgLove.setImageDrawable(getDrawable(R.drawable.love_off_46));
                    } else {
                        Toast.makeText(this, "ERROR : Film gagal dihapus dari daftar Favorit", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    FaveEntity entity = new FaveEntity(movie.getId(),
                            movie.getPhoto(), movie.getName(), movie.getDescription(),
                            movie.getRating(), movie.getReleaseYear(), 0);
                    long result = localRepository.insert(entity);
                    System.out.println("movieOrShow : " + movieOrShow + " | heartState : " + heartState + " | result : " + result);
                    if(result > 0) {
                        Toast.makeText(this, "Film telah ditambahkan ke daftar Favorit", Toast.LENGTH_SHORT).show();
                        heartState = true;
                        imgLove.setImageDrawable(getDrawable(R.drawable.love_on_46));
                    } else {
                        Toast.makeText(this, "ERROR : Film gagal ditambahkan ke daftar Favorit", Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                if(heartState) {
                    FaveEntity entity = new FaveEntity(show.getId(),
                            show.getPhoto(), show.getName(), show.getDescription(),
                            show.getRating(), show.getAiredYears(), 1);
                    int result = localRepository.delete(entity);
                    System.out.println("movieOrShow : " + movieOrShow + " | heartState : " + heartState + " | result : " + result);
                    if(result > 0) {
                        Toast.makeText(this, "Acara TV telah dihapus dari daftar Favorit", Toast.LENGTH_SHORT).show();
                        heartState = false;
                        imgLove.setImageDrawable(getDrawable(R.drawable.love_off_46));
                    } else {
                        Toast.makeText(this, "ERROR : Acara TV gagal dihapus dari daftar Favorit", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    FaveEntity entity = new FaveEntity(show.getId(),
                            show.getPhoto(), show.getName(), show.getDescription(),
                            show.getRating(), show.getAiredYears(), 1);
                    long result = localRepository.insert(entity);
                    System.out.println("movieOrShow : " + movieOrShow + " | heartState : " + heartState + " | result : " + result);
                    if(result > 0) {
                        Toast.makeText(this, "Acara TV telah ditambahkan ke daftar Favorit", Toast.LENGTH_SHORT).show();
                        heartState = true;
                        imgLove.setImageDrawable(getDrawable(R.drawable.love_on_46));
                    } else {
                        Toast.makeText(this, "ERROR : Acara TV gagal ditambahkan ke daftar Favorit", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}
