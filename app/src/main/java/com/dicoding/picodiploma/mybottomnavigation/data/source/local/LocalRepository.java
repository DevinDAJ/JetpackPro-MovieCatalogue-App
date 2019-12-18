package com.dicoding.picodiploma.mybottomnavigation.data.source.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.FaveEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.TVShowEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.room.FaveDao;
import java.util.List;

public class LocalRepository {

    private final FaveDao faveDao;

    public LocalRepository(FaveDao faveDao) {

        this.faveDao = faveDao;
    }

    private static LocalRepository INSTANCE;

    public static LocalRepository getInstance(FaveDao faveDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalRepository(faveDao);
        }
        return INSTANCE;
    }

    public LiveData<List<MovieEntity>> getAllMoviesDB() {
        return faveDao.getAllMovies();
    }

    public DataSource.Factory<Integer, MovieEntity> getAllMoviesAsPaged() {
        return faveDao.getAllMoviesAsPaged();
    }

    public DataSource.Factory<Integer, TVShowEntity> getAllShowsAsPaged() {
        return faveDao.getAllShowsAsPaged();
    }

    public LiveData<List<TVShowEntity>> getAllShowsDB() {
        return faveDao.getAllShows();
    }

    public Boolean checkEntity(String id, int type) {
        return faveDao.checkEntity(id, type).getCount() > 0;
    }

    public long insert(final FaveEntity entity) {
        return faveDao.insert(entity);
    }

    public int update(final FaveEntity entity) {
        return faveDao.update(entity);
    }

    public int delete(final FaveEntity entity) {
        return faveDao.delete(entity);
    }
}
