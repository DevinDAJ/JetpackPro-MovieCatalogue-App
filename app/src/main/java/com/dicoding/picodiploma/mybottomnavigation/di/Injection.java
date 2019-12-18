package com.dicoding.picodiploma.mybottomnavigation.di;

import android.app.Application;

import com.dicoding.picodiploma.mybottomnavigation.data.source.CatalogueRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.LocalRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.room.FaveDatabase;
import com.dicoding.picodiploma.mybottomnavigation.data.source.remote.RemoteRepository;
import com.dicoding.picodiploma.mybottomnavigation.utils.JsonHelper;

public class Injection {
    public static CatalogueRepository provideRepository(Application application) {

        RemoteRepository remoteRepository = RemoteRepository.getInstance(new JsonHelper(application));
        FaveDatabase db = FaveDatabase.getInstance(application);
        LocalRepository localRepository = LocalRepository.getInstance(db.faveDao());

        return CatalogueRepository.getInstance(remoteRepository, localRepository);
    }
}
