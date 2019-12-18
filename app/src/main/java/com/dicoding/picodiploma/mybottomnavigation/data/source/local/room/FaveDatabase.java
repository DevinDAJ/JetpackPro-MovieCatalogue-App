package com.dicoding.picodiploma.mybottomnavigation.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.FaveEntity;

@Database(entities = {FaveEntity.class}, version = 1, exportSchema = false)
public abstract class FaveDatabase extends RoomDatabase {

    public abstract FaveDao faveDao();

    private static volatile FaveDatabase INSTANCE;

    private final static Object sLock = new Object();

    public static FaveDatabase getInstance(final Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        FaveDatabase.class, "fave_database")
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return INSTANCE;
    }
}
