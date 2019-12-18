package com.dicoding.picodiploma.mybottomnavigation.ui.movies.favmovie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dicoding.picodiploma.mybottomnavigation.R;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.mybottomnavigation.ui.detail.DetailActivity;
import com.dicoding.picodiploma.mybottomnavigation.utils.ItemClickSupport;
import com.dicoding.picodiploma.mybottomnavigation.viewmodel.ViewModelFactory;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FaveMovieFragment extends Fragment {

    private RecyclerView rView;
    private Context context;
    private ArrayList<MovieEntity> movies = new ArrayList<>();
    private MoviePagedListAdapter adapter;

    public FaveMovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fave_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getContext();
        FragmentActivity activity = getActivity();
        FaveMovieViewModel viewModel = obtainViewModel(activity);
        adapter = new MoviePagedListAdapter(activity);
        //CardViewFaveMovieAdapter movieAdapter = new CardViewFaveMovieAdapter(context);
        viewModel.getAllMoviesPaged().observe(this, movieObserver);
        rView.setLayoutManager(new LinearLayoutManager(context));
        rView.setHasFixedSize(true);
        rView.setItemAnimator(new DefaultItemAnimator());
        rView.setAdapter(adapter);
        ItemClickSupport.addTo(rView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                goToDetail(position);
            }
        });
    }

    @NonNull
    private static FaveMovieViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(FaveMovieViewModel.class);
    }

    private void initViews(@NonNull View view) {
        rView = view.findViewById(R.id.rv_fave_movie_list);
    }

    private void goToDetail(int i) {
        MovieEntity movie = movies.get(i);

        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("MOVIE", movie);
        startActivity(intent);
    }

    private final Observer<PagedList<MovieEntity>> movieObserver = new Observer<PagedList<MovieEntity>>() {
        @Override
        public void onChanged(PagedList<MovieEntity> movieEntities) {
            if (movieEntities != null) {
                movies.addAll(movieEntities);
                adapter.submitList(movieEntities);
            }
        }
    };
}
