package com.dicoding.picodiploma.mybottomnavigation.ui.movies.favmovie;

import android.widget.TextView;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.mybottomnavigation.FakeDataDummy;
import com.dicoding.picodiploma.mybottomnavigation.data.source.CatalogueRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.LocalRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.room.FaveDao;
import com.dicoding.picodiploma.mybottomnavigation.utils.PagedListUtil;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FaveMovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private FaveMovieViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp() {
        viewModel = new FaveMovieViewModel(catalogueRepository);
    }

    @Test
    public void getMoviesFromDB() {
        PagedList<MovieEntity> dummyMovies = PagedListUtil.mockPagedList(FakeDataDummy.generateDummyMovies());

        MutableLiveData<PagedList<MovieEntity>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(catalogueRepository.getAllMoviesPaged()).thenReturn(movies);

        Observer<List<MovieEntity>> observer = mock(Observer.class);

        viewModel.getAllMoviesPaged().observeForever(observer);

        verify(observer).onChanged(dummyMovies);
    }
}
