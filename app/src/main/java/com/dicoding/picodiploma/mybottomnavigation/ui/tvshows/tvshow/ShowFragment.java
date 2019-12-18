package com.dicoding.picodiploma.mybottomnavigation.ui.tvshows.tvshow;


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
import com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity.TVShowEntity;
import com.dicoding.picodiploma.mybottomnavigation.ui.detail.DetailActivity;
import com.dicoding.picodiploma.mybottomnavigation.utils.ItemClickSupport;
import com.dicoding.picodiploma.mybottomnavigation.viewmodel.ViewModelFactory;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFragment extends Fragment {

    private ArrayList<TVShowEntity> shows = new ArrayList<>();

    private RecyclerView rView;

    private Context context;

    private ProgressBar progressBar;

    public ShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show, container, false);
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
            ShowViewModel viewModel = obtainViewModel(getActivity());
            CardViewShowAdapter cvShowAdapter = new CardViewShowAdapter(context);
            viewModel.getShows().observe(this, sShows -> {
                if(sShows != null) {
                    progressBar.setVisibility(View.GONE);
                    shows.addAll(sShows);
                    cvShowAdapter.setListShows(sShows);
                    cvShowAdapter.notifyDataSetChanged();
                    rView.setAdapter(cvShowAdapter);
                    rView.setLayoutManager(new LinearLayoutManager(context));
                    rView.setHasFixedSize(true);

                } else {
                    System.out.println("SHOW sShows NULL!!!!");
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
    private static ShowViewModel obtainViewModel(FragmentActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(ShowViewModel.class);
    }

    private void initView(View view) {
        progressBar = view.findViewById(R.id.progress_circular_show);
        rView = view.findViewById(R.id.rv_show_list);
    }

    private void goToDetailPage(int i) {
        TVShowEntity show = shows.get(i);

        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("SHOW", show);
        startActivity(intent);
    }

}
