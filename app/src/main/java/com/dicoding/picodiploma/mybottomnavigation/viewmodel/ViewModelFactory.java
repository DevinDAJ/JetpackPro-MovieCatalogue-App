package com.dicoding.picodiploma.mybottomnavigation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.dicoding.picodiploma.mybottomnavigation.data.source.CatalogueRepository;
import com.dicoding.picodiploma.mybottomnavigation.ui.detail.DetailViewModel;
import com.dicoding.picodiploma.mybottomnavigation.di.Injection;
import com.dicoding.picodiploma.mybottomnavigation.ui.movies.favmovie.FaveMovieViewModel;
import com.dicoding.picodiploma.mybottomnavigation.ui.movies.movie.MovieViewModel;
import com.dicoding.picodiploma.mybottomnavigation.ui.tvshows.favtvshow.FaveShowViewModel;
import com.dicoding.picodiploma.mybottomnavigation.ui.tvshows.tvshow.ShowViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final CatalogueRepository catalogueRepository;

    private ViewModelFactory(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(application));
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            //noinspection unchecked
            return (T) new MovieViewModel(catalogueRepository);
        } else if (modelClass.isAssignableFrom(ShowViewModel.class)) {
            //noinspection unchecked
            return (T) new ShowViewModel(catalogueRepository);
        } else if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            //noinspection unchecked
            return (T) new DetailViewModel(catalogueRepository);
        } else if (modelClass.isAssignableFrom(FaveMovieViewModel.class)) {
            //noinspection unchecked
            return (T) new FaveMovieViewModel(catalogueRepository);
        } else if (modelClass.isAssignableFrom(FaveShowViewModel.class)) {
            //noinspection unchecked
            return (T) new FaveShowViewModel(catalogueRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
