package com.dicoding.picodiploma.mybottomnavigation.utils;

import android.app.Application;

import com.dicoding.picodiploma.mybottomnavigation.data.source.remote.response.MovieResponse;
import com.dicoding.picodiploma.mybottomnavigation.data.source.remote.response.TvshowResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;

public class JsonHelper {

    private Application application;

    public JsonHelper(Application application) {
        this.application = application;
    }

    private String parsingFileToString(String fileName) {
        try {
            InputStream is = application.getAssets().open(fileName);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<MovieResponse> loadMovies() {
        ArrayList<MovieResponse> list = new ArrayList<>();

        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("MovieResponses.json"));
            JSONArray listArray = responseObject.getJSONArray("movies");
            for(int i = 0; i < listArray.length(); i++) {
                JSONObject movie = listArray.getJSONObject(i);

                String id = String.valueOf(movie.getInt("id"));
                String photo = "https://image.tmdb.org/t/p/w185"+movie.getString("poster_path");
                String name = movie.getString("title");
                String description = movie.getString("overview");
                String rating = String.valueOf(BigDecimal.valueOf(movie.getDouble("vote_average")).floatValue());
                String releaseYear = movie.getString("release_date");

                MovieResponse movieResponse = new MovieResponse(id, photo, name, description, rating, releaseYear);
                list.add(movieResponse);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public MovieResponse loadMovies(String movieId) {
        MovieResponse movieResponse = new MovieResponse();

        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("MovieResponses.json"));
            JSONArray listArray = responseObject.getJSONArray("movies");
            for(int i = 0; i < listArray.length(); i++) {
                JSONObject movie = listArray.getJSONObject(i);

                if(String.valueOf(movie.getInt("id")).equals(movieId)) {
                    String id = String.valueOf(movie.getInt("id"));
                    String photo = "https://image.tmdb.org/t/p/w185"+movie.getString("poster_path");
                    String name = movie.getString("title");
                    String description = movie.getString("overview");
                    String rating = String.valueOf(BigDecimal.valueOf(movie.getDouble("vote_average")).floatValue());
                    String releaseYear = movie.getString("release_date");

                    movieResponse = new MovieResponse(id, photo, name, description, rating, releaseYear);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movieResponse;
    }

    public ArrayList<TvshowResponse> loadShows() {
        ArrayList<TvshowResponse> list = new ArrayList<>();

        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("TvshowsResponses.json"));
            JSONArray listArray = responseObject.getJSONArray("tvshows");
            for(int i = 0; i < listArray.length(); i++) {
                JSONObject show = listArray.getJSONObject(i);

                String id = String.valueOf(show.getInt("id"));
                String photo = "https://image.tmdb.org/t/p/w185"+show.getString("poster_path");
                String name = show.getString("name");
                String description = show.getString("overview");
                String rating = String.valueOf(BigDecimal.valueOf(show.getDouble("vote_average")).floatValue());
                String airedYears = show.getString("first_air_date");

                TvshowResponse tvshowResponse = new TvshowResponse(id, photo, name, description, rating, airedYears);
                list.add(tvshowResponse);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public TvshowResponse loadShows(String showId) {
        TvshowResponse tvshowResponse = new TvshowResponse();

        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("TvshowsResponses.json"));
            JSONArray listArray = responseObject.getJSONArray("tvshows");
            for(int i = 0; i < listArray.length(); i++) {
                JSONObject show = listArray.getJSONObject(i);

                if(String.valueOf(show.getInt("id")).equals(showId)) {
                    String id = String.valueOf(show.getInt("id"));
                    String photo = "https://image.tmdb.org/t/p/w185"+show.getString("poster_path");
                    String name = show.getString("name");
                    String description = show.getString("overview");
                    String rating = String.valueOf(BigDecimal.valueOf(show.getDouble("vote_average")).floatValue());
                    String airedYears = show.getString("first_air_date");

                    tvshowResponse = new TvshowResponse(id, photo, name, description, rating, airedYears);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tvshowResponse;
    }
}
