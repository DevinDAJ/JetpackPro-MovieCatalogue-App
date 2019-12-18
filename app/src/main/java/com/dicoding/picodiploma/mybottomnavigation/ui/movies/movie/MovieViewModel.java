package com.dicoding.picodiploma.mybottomnavigation.ui.movies.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.mybottomnavigation.data.source.CatalogueRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;

import java.util.ArrayList;

public class MovieViewModel extends ViewModel {

    private CatalogueRepository catalogueRepository;

    public MovieViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public LiveData<ArrayList<MovieEntity>> getMovies() {
        return catalogueRepository.getAllMovies();
    }
}
