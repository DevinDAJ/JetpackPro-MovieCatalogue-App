package com.dicoding.picodiploma.mybottomnavigation.data.source;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.FaveEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.TVShowEntity;


import java.util.ArrayList;
import java.util.List;

public interface CatalogueDataSource {

    LiveData<List<MovieEntity>> getAllMoviesFromDB();

    LiveData<PagedList<MovieEntity>> getAllMoviesPaged();

    LiveData<List<TVShowEntity>> getAllShowsFromDB();

    LiveData<PagedList<TVShowEntity>> getAllShowsPaged();

    Boolean checkEntity(String id, int type);

    long insert(FaveEntity entity);

    int delete(FaveEntity entity);

    LiveData<ArrayList<MovieEntity>> getAllMovies();

    LiveData<ArrayList<TVShowEntity>> getAllShows();

    LiveData<MovieEntity> getMovie(String movieId);

    LiveData<TVShowEntity> getShow(String showId);
}
