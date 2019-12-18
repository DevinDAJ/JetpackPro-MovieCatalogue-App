package com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class MovieEntity implements Parcelable {

    @NonNull
    @PrimaryKey()
    @ColumnInfo(name = "itemId")
    private String id;

    @ColumnInfo(name = "itemPhoto")
    private String photo;

    @ColumnInfo(name = "itemName")
    private String name;

    @ColumnInfo(name = "itemDesc")
    private String description;

    @ColumnInfo(name = "itemRating")
    private String rating;

    @ColumnInfo(name = "itemYear")
    private String releaseYear;

    @Ignore
    public MovieEntity() {

    }

    public MovieEntity(String id, String photo, String name, String description,
                       String rating, String releaseYear) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    protected MovieEntity(Parcel in) {
        id = in.readString();
        photo = in.readString();
        name = in.readString();
        description = in.readString();
        rating = in.readString();
        releaseYear = in.readString();
    }

    public static final Creator<MovieEntity> CREATOR = new Creator<MovieEntity>() {
        @Override
        public MovieEntity createFromParcel(Parcel in) {
            return new MovieEntity(in);
        }

        @Override
        public MovieEntity[] newArray(int size) {
            return new MovieEntity[size];
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
