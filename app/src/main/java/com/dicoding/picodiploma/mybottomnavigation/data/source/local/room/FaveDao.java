package com.dicoding.picodiploma.mybottomnavigation.data.source.local.room;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.FaveEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.TVShowEntity;

import java.util.List;

@Dao
public interface FaveDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(FaveEntity entity);

    @Update(onConflict = OnConflictStrategy.FAIL)
    int update(FaveEntity entity);

    @Delete()
    int delete(FaveEntity entity);

    @Query("SELECT itemId, itemPhoto, itemName, itemDesc, itemRating, itemYear FROM faveentity WHERE itemType = 0 ORDER BY itemId ASC")
    LiveData<List<MovieEntity>> getAllMovies();

    @Query("SELECT itemId, itemPhoto, itemName, itemDesc, itemRating, itemYear FROM faveentity WHERE itemType = 0 ORDER BY itemId ASC")
    DataSource.Factory<Integer, MovieEntity> getAllMoviesAsPaged();

    @Query("SELECT itemId, itemPhoto, itemName, itemDesc, itemRating, itemYear FROM faveentity WHERE itemType = 1 ORDER BY itemId ASC")
    LiveData<List<TVShowEntity>> getAllShows();

    @Query("SELECT itemId, itemPhoto, itemName, itemDesc, itemRating, itemYear FROM faveentity WHERE itemType = 1 ORDER BY itemId ASC")
    DataSource.Factory<Integer, TVShowEntity> getAllShowsAsPaged();

    @Query("SELECT * FROM faveentity WHERE itemId = :id AND itemType = :type")
    Cursor checkEntity(String id, int type);
}