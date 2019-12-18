package com.dicoding.picodiploma.mybottomnavigation.ui.movies.favmovie;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.mybottomnavigation.data.source.CatalogueRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;

import java.util.List;

public class FaveMovieViewModel extends ViewModel {

    private CatalogueRepository catalogueRepository;

    public FaveMovieViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public LiveData<List<MovieEntity>> getAllMovies() {
        return catalogueRepository.getAllMoviesFromDB();
    }

    public LiveData<PagedList<MovieEntity>> getAllMoviesPaged() {
        return catalogueRepository.getAllMoviesPaged();
    }


}
