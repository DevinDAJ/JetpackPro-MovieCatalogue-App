package com.dicoding.picodiploma.mybottomnavigation.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieResponse implements Parcelable {
    private String id;
    private String photo;
    private String name;
    private String description;
    private String rating;
    private String releaseYear;

    public MovieResponse() {

    }

    public MovieResponse(String id, String photo, String name, String description,
                         String rating, String releaseYear) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    protected MovieResponse(Parcel in) {
        id = in.readString();
        photo = in.readString();
        name = in.readString();
        description = in.readString();
        rating = in.readString();
        releaseYear = in.readString();
    }

    public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
        @Override
        public MovieResponse createFromParcel(Parcel in) {
            return new MovieResponse(in);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(photo);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(rating);
        dest.writeString(releaseYear);
    }
}
