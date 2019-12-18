package com.dicoding.picodiploma.mybottomnavigation.main;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dicoding.picodiploma.mybottomnavigation.R;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.mybottomnavigation.ui.movies.favmovie.FaveMovieFragment;
import com.dicoding.picodiploma.mybottomnavigation.ui.movies.favmovie.MoviePagedListAdapter;
import com.dicoding.picodiploma.mybottomnavigation.ui.tvshows.favtvshow.FaveShowFragment;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class FaveMainFragment extends Fragment {

    private TabLayout tabLayout;

    public FaveMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fave_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        tabLayout = view.findViewById(R.id.tab_layout);

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment faveMovieFragment = new FaveMovieFragment();
        Fragment fragment = fragmentManager.findFragmentByTag(FaveMovieFragment.class.getSimpleName());
        if(!(fragment instanceof FaveMovieFragment)) {
            fragmentTransaction.replace(R.id.fave_container, faveMovieFragment, FaveMovieFragment.class.getSimpleName());
            fragmentTransaction.commit();
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        initFaveMovieFragment();
                    case 1:
                        initFaveTVShowFragment();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initFaveMovieFragment() {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment faveMovieFragment = new FaveMovieFragment();
        Fragment fragment = fragmentManager.findFragmentByTag(FaveMovieFragment.class.getSimpleName());
        if(!(fragment instanceof FaveMovieFragment)) {
            fragmentTransaction.replace(R.id.fave_container, faveMovieFragment, FaveMovieFragment.class.getSimpleName());
            fragmentTransaction.commit();
        }
    }

    private void initFaveTVShowFragment() {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment faveTVShowFragment = new FaveShowFragment();
        Fragment fragment = fragmentManager.findFragmentByTag(FaveShowFragment.class.getSimpleName());
        if(!(fragment instanceof FaveShowFragment)) {
            fragmentTransaction.replace(R.id.fave_container, faveTVShowFragment, FaveShowFragment.class.getSimpleName());
            fragmentTransaction.commit();
        }
    }

}
