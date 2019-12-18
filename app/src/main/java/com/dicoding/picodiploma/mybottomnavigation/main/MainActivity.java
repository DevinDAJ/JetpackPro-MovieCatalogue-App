package com.dicoding.picodiploma.mybottomnavigation.main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.dicoding.picodiploma.mybottomnavigation.R;
import com.dicoding.picodiploma.mybottomnavigation.ui.movies.movie.MovieFragment;
import com.dicoding.picodiploma.mybottomnavigation.ui.tvshows.tvshow.ShowFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_movies:
                    initMovieFragment();
                    return true;
                case R.id.navigation_shows:
                    initShowFragment();
                    return true;
                case R.id.navigation_fav:
                    initFaveFragment();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
        if(savedInstanceState == null) {
            initMovieFragment();
        }
    }

    private void initMovieFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment movieFragment = new MovieFragment();
        Fragment fragment = fragmentManager.findFragmentByTag(MovieFragment.class.getSimpleName());
        if(!(fragment instanceof MovieFragment)) {
            fragmentTransaction.replace(R.id.container, movieFragment, MovieFragment.class.getSimpleName());
            fragmentTransaction.commit();
        }
    }

    private void initShowFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment showFragment = new ShowFragment();
        Fragment fragment = fragmentManager.findFragmentByTag(ShowFragment.class.getSimpleName());
        if(!(fragment instanceof ShowFragment)) {
            fragmentTransaction.replace(R.id.container, showFragment, ShowFragment.class.getSimpleName());
            fragmentTransaction.commit();
        }
    }

    private void initFaveFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment faveFragment = new FaveMainFragment();
        Fragment fragment = fragmentManager.findFragmentByTag(FaveMainFragment.class.getSimpleName());
        if(!(fragment instanceof FaveMainFragment)) {
            fragmentTransaction.replace(R.id.container, faveFragment, FaveMainFragment.class.getSimpleName());
            fragmentTransaction.commit();
        }
    }

    private void initViews() {
        navView = findViewById(R.id.nav_view);
    }

    private void initListeners() {
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}
