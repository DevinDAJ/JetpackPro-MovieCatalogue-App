package com.dicoding.picodiploma.mybottomnavigation.data.source.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class FaveEntity implements Parcelable {

    @PrimaryKey()
    @ColumnInfo(name = "itemId")
    @NonNull
    private String itemId;

    @ColumnInfo(name = "itemPhoto")
    private String itemPhoto;

    @ColumnInfo(name = "itemName")
    private String itemName;

    @ColumnInfo(name = "itemDesc")
    private String itemDesc;

    @ColumnInfo(name = "itemRating")
    private String itemRating;

    @ColumnInfo(name = "itemYear")
    private String itemYear;

    @ColumnInfo(name = "itemType")
    private int itemType;

    protected FaveEntity(Parcel in) {
        itemId = in.readString();
        itemPhoto = in.readString();
        itemName = in.readString();
        itemDesc = in.readString();
        itemRating = in.readString();
        itemYear = in.readString();
        itemType = in.readInt();
    }

    @Ignore
    public FaveEntity() {

    }

    public FaveEntity(String itemId, String itemPhoto, String itemName, String itemDesc,
                      String itemRating, String itemYear, int itemType) {

        this.itemId = itemId;
        this.itemPhoto = itemPhoto;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemRating = itemRating;
        this.itemYear = itemYear;
        this.itemType = itemType;
    }

    public static final Creator<FaveEntity> CREATOR = new Creator<FaveEntity>() {
        @Override
        public FaveEntity createFromParcel(Parcel in) {
            return new FaveEntity(in);
        }

        @Override
        public FaveEntity[] newArray(int size) {
            return new FaveEntity[size];
        }
    };

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemPhoto() {
        return itemPhoto;
    }

    public void setItemPhoto(String itemPhoto) {
        this.itemPhoto = itemPhoto;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemRating() {
        return itemRating;
    }

    public void setItemRating(String itemRating) {
        this.itemRating = itemRating;
    }

    public String getItemYear() {
        return itemYear;
    }

    public void setItemYear(String itemYear) {
        this.itemYear = itemYear;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemId);
        dest.writeString(itemPhoto);
        dest.writeString(itemName);
        dest.writeString(itemDesc);
        dest.writeString(itemRating);
        dest.writeString(itemYear);
        dest.writeInt(itemType);
    }
}
