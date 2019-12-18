package com.dicoding.picodiploma.mybottomnavigation.ui.movies.movie;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dicoding.picodiploma.mybottomnavigation.R;
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.MovieEntity;
import com.dicoding.picodiploma.mybottomnavigation.ui.detail.DetailActivity;
import com.dicoding.picodiploma.mybottomnavigation.utils.ItemClickSupport;
import com.dicoding.picodiploma.mybottomnavigation.viewmodel.ViewModelFactory;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private ArrayList<MovieEntity> movies = new ArrayList<>();

    private RecyclerView rView;

    private Context context;

    private ProgressBar progressBar;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, viewGroup, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // do things right after the fragment is completely inflated
        initView(view);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity() != null) {
            progressBar.setVisibility(View.VISIBLE);
            context = getActivity();
            MovieViewModel viewModel = obtainViewModel(getActivity());
            CardViewMovieAdapter cvMovieAdapter = new CardViewMovieAdapter(context);
            viewModel.getMovies().observe(this, mMovies -> {
                if(mMovies != null) {
                    progressBar.setVisibility(View.GONE);
                    movies.addAll(mMovies);
                    cvMovieAdapter.setListMovies(mMovies);
                    cvMovieAdapter.notifyDataSetChanged();
                    rView.setAdapter(cvMovieAdapter);
                    rView.setLayoutManager(new LinearLayoutManager(context));
                    rView.setHasFixedSize(true);
                } else {
                    System.out.println("MOVIE mMovies NULL!!!");
                }
            });


            ItemClickSupport.addTo(rView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                @Override
                public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                    goToDetailPage(position);
                }
            });
        }
    }

    @NonNull
    private static MovieViewModel obtainViewModel(FragmentActivity activity) {
        // Use a factory to inject dependencies into the viewmodel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(MovieViewModel.class);
    }

    private void initView(View view) {
        progressBar = view.findViewById(R.id.progress_circular_movie);
        rView = view.findViewById(R.id.rv_movie_list);
    }

    private void goToDetailPage(int i) {
        MovieEntity movie = movies.get(i);

        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("MOVIE", movie);
        startActivity(intent);
    }
}
