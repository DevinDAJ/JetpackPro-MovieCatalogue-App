package com.dicoding.picodiploma.mybottomnavigation.ui.tvshows.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.mybottomnavigation.data.source.CatalogueRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.TVShowEntity;

import java.util.ArrayList;

public class ShowViewModel extends ViewModel {

    private CatalogueRepository catalogueRepository;

    public ShowViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public LiveData<ArrayList<TVShowEntity>> getShows() {
        return catalogueRepository.getAllShows();
    }
}
