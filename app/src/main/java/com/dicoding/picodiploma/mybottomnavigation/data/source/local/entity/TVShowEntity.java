package com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class TVShowEntity implements Parcelable {

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
    private String airedYears;

    @Ignore
    public TVShowEntity() {

    }

    public TVShowEntity(String id, String photo, String name, String description,
                        String rating, String airedYears) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.airedYears = airedYears;
    }

    protected TVShowEntity(Parcel in) {
        id = in.readString();
        photo = in.readString();
        name = in.readString();
        description = in.readString();
        rating = in.readString();
        airedYears = in.readString();
    }

    public static final Creator<TVShowEntity> CREATOR = new Creator<TVShowEntity>() {
        @Override
        public TVShowEntity createFromParcel(Parcel in) {
            return new TVShowEntity(in);
        }

        @Override
        public TVShowEntity[] newArray(int size) {
            return new TVShowEntity[size];
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

    public String getAiredYears() {
        return airedYears;
    }

    public void setAiredYears(String airedYears) {
        this.airedYears = airedYears;
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
        dest.writeString(airedYears);
    }
}