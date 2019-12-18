package com.dicoding.picodiploma.mybottomnavigation.ui.tvshows.tvshow;


import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.dicoding.picodiploma.mybottomnavigation.FakeDataDummy;
import com.dicoding.picodiploma.mybottomnavigation.data.source.CatalogueRepository;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.TVShowEntity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShowViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private ShowViewModel viewModel;
    private CatalogueRepository catalogueRepository = mock(CatalogueRepository.class);

    @Before
    public void setUp() {
        viewModel = new ShowViewModel(catalogueRepository);
    }

    @Test
    public void getShows() {
        ArrayList<TVShowEntity> dummyShows = FakeDataDummy.generateDummyTVShows();

        MutableLiveData<ArrayList<TVShowEntity>> shows = new MutableLiveData<>();
        shows.setValue(dummyShows);

        when(catalogueRepository.getAllShows()).thenReturn(shows);

        Observer<ArrayList<TVShowEntity>> observer = mock(Observer.class);

        viewModel.getShows().observeForever(observer);

        verify(observer).onChanged(dummyShows);
    }
}