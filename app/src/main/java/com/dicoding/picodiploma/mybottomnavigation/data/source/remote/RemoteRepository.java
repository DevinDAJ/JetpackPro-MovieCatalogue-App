package com.dicoding.picodiploma.mybottomnavigation.data.source.remote;

import com.dicoding.picodiploma.mybottomnavigation.data.source.remote.response.MovieResponse;
import com.dicoding.picodiploma.mybottomnavigation.data.source.remote.response.TvshowResponse;
import com.dicoding.picodiploma.mybottomnavigation.utils.EspressoIdlingResource;
import com.dicoding.picodiploma.mybottomnavigation.utils.JsonHelper;

import java.util.ArrayList;

public class RemoteRepository {
    private static RemoteRepository INSTANCE;
    private JsonHelper jsonHelper;

    private RemoteRepository(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteRepository getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository(helper);
        }
        return INSTANCE;
    }

    public void getAllMovies(LoadMoviesCallback callback) {
        EspressoIdlingResource.increment();
        callback.onAllMoviesRecieved(jsonHelper.loadMovies());
        EspressoIdlingResource.decrement();
    }

    public void getAllShows(LoadShowsCallback callback) {
        EspressoIdlingResource.increment();
        callback.onAllShowsRecieved(jsonHelper.loadShows());
        EspressoIdlingResource.decrement();
    }

    public void getMovie(String movieId, LoadMovieCallback callback) {
        EspressoIdlingResource.increment();
        callback.onMovieRecieved(jsonHelper.loadMovies(movieId));
        EspressoIdlingResource.decrement();
    }

    public void getShow(String showId, LoadShowCallback callback) {
        EspressoIdlingResource.increment();
        callback.onShowRecieved(jsonHelper.loadShows(showId));
        EspressoIdlingResource.decrement();
    }

    public interface LoadMoviesCallback {
        void onAllMoviesRecieved(ArrayList<MovieResponse> movieResponses);

        void onDataNotAvailable();
    }

    public interface LoadShowsCallback {
        void onAllShowsRecieved(ArrayList<TvshowResponse> tvshowResponses);

        void onDataNotAvaiable();
    }

    public interface LoadMovieCallback {
        void onMovieRecieved(MovieResponse movieResponse);

        void onDataNotAvailable();
    }

    public interface LoadShowCallback {
        void onShowRecieved(TvshowResponse tvshowResponse);

        void onDataNotAvaiable();
    }
}
