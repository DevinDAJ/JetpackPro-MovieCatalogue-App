package com.dicoding.picodiploma.mybottomnavigation.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.dicoding.picodiploma.mybottomnavigation.FakeDataDummy;
import com.dicoding.picodiploma.mybottomnavigation.data.source.CatalogueRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.TVShowEntity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private DetailViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);
    private MovieEntity dummyMovie = FakeDataDummy.generateDummyMovies().get(0);
    private String movieId = dummyMovie.getId();
    private TVShowEntity dummyTvshow = FakeDataDummy.generateDummyTVShows().get(0);
    private String showId = dummyTvshow.getId();


    @Before
    public void setUp() {
        viewModel = new DetailViewModel(catalogueRepository);
        viewModel.setMovieId(movieId);
        viewModel.setTvshowId(showId);
    }

    @Test
    public void fecthMovie() {
        MutableLiveData<MovieEntity> movieEntities = new MutableLiveData<>();
        movieEntities.setValue(dummyMovie);

        when(catalogueRepository.getMovie(movieId)).thenReturn(movieEntities);

        Observer<MovieEntity> observer = mock(Observer.class);

        viewModel.fecthMovie().observeForever(observer);

        verify(observer).onChanged(dummyMovie);
    }

    @Test
    public void fetchShow() {
        MutableLiveData<TVShowEntity> showEntities = new MutableLiveData<>();
        showEntities.setValue(dummyTvshow);

        when(catalogueRepository.getShow(showId)).thenReturn(showEntities);

        Observer<TVShowEntity> observer = mock(Observer.class);

        viewModel.fetchShow().observeForever(observer);

        verify(observer).onChanged(dummyTvshow);
    }
}