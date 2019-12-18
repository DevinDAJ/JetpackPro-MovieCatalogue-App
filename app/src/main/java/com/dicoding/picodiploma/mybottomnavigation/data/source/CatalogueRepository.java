package com.dicoding.picodiploma.mybottomnavigation.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.mybottomnavigation.data.source.local.LocalRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.FaveEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.TVShowEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.remote.RemoteRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.remote.response.MovieResponse;
import com.dicoding.picodiploma.mybottomnavigation.data.source.remote.response.TvshowResponse;

import java.util.ArrayList;
import java.util.List;

public class CatalogueRepository implements CatalogueDataSource {

    private volatile static CatalogueRepository INSTANCE = null;

    private final RemoteRepository remoteRepository;
    private final LocalRepository localRepository;

    private CatalogueRepository(@NonNull RemoteRepository remoteRepository, @NonNull LocalRepository localRepository) {
        this.remoteRepository = remoteRepository;
        this.localRepository = localRepository;
    }

    public static CatalogueRepository getInstance(RemoteRepository remoteData, LocalRepository localData) {
        if (INSTANCE == null) {
            synchronized (CatalogueRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CatalogueRepository(remoteData, localData);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<MovieEntity>> getAllMoviesFromDB() {
        return localRepository.getAllMoviesDB();
    }

    @Override
    public LiveData<PagedList<MovieEntity>> getAllMoviesPaged() {
        return new LivePagedListBuilder<>(localRepository.getAllMoviesAsPaged(), 20).build();
    }

    @Override
    public LiveData<List<TVShowEntity>> getAllShowsFromDB() {
        return localRepository.getAllShowsDB();
    }

    @Override
    public LiveData<PagedList<TVShowEntity>> getAllShowsPaged() {
        return new LivePagedListBuilder<>(localRepository.getAllShowsAsPaged(), 20).build();
    }

    @Override
    public Boolean checkEntity(String id, int type) {
        return localRepository.checkEntity(id, type);
    }

    @Override
    public long insert(FaveEntity entity) {
        return localRepository.insert(entity);
    }

    @Override
    public int delete(FaveEntity entity) {
        return localRepository.delete(entity);
    }

    @Override
    public LiveData<ArrayList<MovieEntity>> getAllMovies() {
        MutableLiveData<ArrayList<MovieEntity>> movieResults = new MutableLiveData<>();
        remoteRepository.getAllMovies(new RemoteRepository.LoadMoviesCallback() {
            @Override
            public void onAllMoviesRecieved(ArrayList<MovieResponse> movieResponses) {
                ArrayList<MovieEntity> movieList = new ArrayList<>();
                for(int i = 0; i < movieResponses.size(); i++) {
                    MovieResponse response = movieResponses.get(i);
                    MovieEntity movie = new MovieEntity(
                            response.getId(),
                            response.getPhoto(),
                            response.getName(),
                            response.getDescription(),
                            response.getRating(),
                            response.getReleaseYear());
                    movieList.add(movie);
                }
                movieResults.postValue(movieList);
            }

            @Override
            public void onDataNotAvailable() {
                System.out.println("getAllMovies : onDataNotAvaiable");
            }
        });
        return movieResults;
    }

    @Override
    public LiveData<ArrayList<TVShowEntity>> getAllShows() {
        MutableLiveData<ArrayList<TVShowEntity>> showResults = new MutableLiveData<>();
        remoteRepository.getAllShows(new RemoteRepository.LoadShowsCallback() {
            @Override
            public void onAllShowsRecieved(ArrayList<TvshowResponse> tvshowResponses) {
                ArrayList<TVShowEntity> showList = new ArrayList<>();
                for(int i = 0; i < tvshowResponses.size(); i++) {
                    TvshowResponse response = tvshowResponses.get(i);
                    TVShowEntity show = new TVShowEntity(
                            response.getId(),
                            response.getPhoto(),
                            response.getName(),
                            response.getDescription(),
                            response.getRating(),
                            response.getAiredYears());
                    showList.add(show);
                }
                showResults.postValue(showList);
            }

            @Override
            public void onDataNotAvaiable() {
                System.out.println("getAllShows : onDataNotAvaiable");
            }
        });
        return showResults;
    }

    @Override
    public LiveData<MovieEntity> getMovie(String movieId) {
        MutableLiveData<MovieEntity> movieResult = new MutableLiveData<>();

        remoteRepository.getMovie(movieId, new RemoteRepository.LoadMovieCallback() {
            @Override
            public void onMovieRecieved(MovieResponse movieResponse) {
                MovieEntity movie = new MovieEntity();

                movie.setId(movieResponse.getId());
                movie.setPhoto(movieResponse.getPhoto());
                movie.setName(movieResponse.getName());
                movie.setDescription(movieResponse.getDescription());
                movie.setRating(movieResponse.getRating());
                movie.setReleaseYear(movieResponse.getReleaseYear());

                movieResult.postValue(movie);
            }

            @Override
            public void onDataNotAvailable() {
                System.out.println("getAllMovies : onDataNotAvaiable");
            }
        });
        return movieResult;
    }

    @Override
    public LiveData<TVShowEntity> getShow(String showId) {
        MutableLiveData<TVShowEntity> showResult = new MutableLiveData<>();

        remoteRepository.getShow(showId, new RemoteRepository.LoadShowCallback() {
            @Override
            public void onShowRecieved(TvshowResponse tvshowResponse) {
                TVShowEntity show = new TVShowEntity();

                show.setId(tvshowResponse.getId());
                show.setPhoto(tvshowResponse.getPhoto());
                show.setName(tvshowResponse.getName());
                show.setDescription(tvshowResponse.getDescription());
                show.setRating(tvshowResponse.getRating());
                show.setAiredYears(tvshowResponse.getAiredYears());

                showResult.postValue(show);
            }

            @Override
            public void onDataNotAvaiable() {
                System.out.println("getAllShows : onDataNotAvaiable");
            }
        });
        return showResult;
    }
}
