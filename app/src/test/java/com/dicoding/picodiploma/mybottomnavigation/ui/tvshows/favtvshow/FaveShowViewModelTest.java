package com.dicoding.picodiploma.mybottomnavigation.ui.tvshows.favtvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.mybottomnavigation.FakeDataDummy;
import com.dicoding.picodiploma.mybottomnavigation.data.source.CatalogueRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.TVShowEntity;
import com.dicoding.picodiploma.mybottomnavigation.ui.movies.favmovie.FaveMovieViewModel;
import com.dicoding.picodiploma.mybottomnavigation.utils.PagedListUtil;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FaveShowViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private FaveShowViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp() {
        viewModel = new FaveShowViewModel(catalogueRepository);
    }

    @Test
    public void getMoviesFromDB() {
        PagedList<TVShowEntity> dummyShows = PagedListUtil.mockPagedList(FakeDataDummy.generateDummyTVShows());

        MutableLiveData<PagedList<TVShowEntity>> shows = new MutableLiveData<>();
        shows.setValue(dummyShows);

        when(catalogueRepository.getAllShowsPaged()).thenReturn(shows);

        Observer<PagedList<TVShowEntity>> observer = mock(Observer.class);

        viewModel.getAllShowsPaged().observeForever(observer);

        verify(observer).onChanged(dummyShows);
    }
}
