package com.dicoding.picodiploma.mybottomnavigation.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.mybottomnavigation.data.source.CatalogueRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.TVShowEntity;

public class DetailViewModel extends ViewModel {

    private String movieId;
    private String tvshowId;
    private CatalogueRepository catalogueRepository;

    public DetailViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setTvshowId(String tvshowId) {
        this.tvshowId = tvshowId;
    }

    public LiveData<MovieEntity> fecthMovie() {
        return catalogueRepository.getMovie(movieId);
    }

    public LiveData<TVShowEntity> fetchShow() {
        return catalogueRepository.getShow(tvshowId);
    }
}
