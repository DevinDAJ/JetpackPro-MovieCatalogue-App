package com.dicoding.picodiploma.mybottomnavigation.ui.movies.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.dicoding.picodiploma.mybottomnavigation.FakeDataDummy;
import com.dicoding.picodiploma.mybottomnavigation.data.source.CatalogueRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MovieViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp() {
        viewModel = new MovieViewModel(catalogueRepository);
    }

    @Test
    public void getMovies() {
        ArrayList<MovieEntity> dummyMovies = FakeDataDummy.generateDummyMovies();

        MutableLiveData<ArrayList<MovieEntity>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(catalogueRepository.getAllMovies()).thenReturn(movies);

        Observer<ArrayList<MovieEntity>> observer = mock(Observer.class);

        viewModel.getMovies().observeForever(observer);

        verify(observer).onChanged(dummyMovies);
    }
}