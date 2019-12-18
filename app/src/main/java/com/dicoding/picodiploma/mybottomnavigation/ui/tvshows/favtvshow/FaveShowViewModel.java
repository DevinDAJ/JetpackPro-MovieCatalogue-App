package com.dicoding.picodiploma.mybottomnavigation.ui.tvshows.favtvshow;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.mybottomnavigation.data.source.CatalogueRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.LocalRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.FaveEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.TVShowEntity;

import java.util.List;

public class FaveShowViewModel extends ViewModel {

    private CatalogueRepository catalogueRepository;

    public FaveShowViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public LiveData<List<TVShowEntity>> getAllShows() {
        return catalogueRepository.getAllShowsFromDB();
    }

    public LiveData<PagedList<TVShowEntity>> getAllShowsPaged() {
        return catalogueRepository.getAllShowsPaged();
    }
}
