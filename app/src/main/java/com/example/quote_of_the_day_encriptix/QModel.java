package com.example.quote_of_the_day_encriptix;


import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

@SuppressLint("ParcelCreator")
public class QModel implements  Parcelable {
    private String text;
    private String author;
    private Boolean isselected;


    public QModel(String text, String auther) {
        this.text = text;
        this.author = auther;
        isselected=false;
    }

    public QModel() {
    }



    public Boolean isselected() {
        return isselected;
    }

    public void setSelected(Boolean selected) {
        isselected = selected;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @NonNull
    @Override
    public String toString() {
        return "QModel{" +
                "text=" + text + "author=" + author + "}";

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeString(author);
        dest.writeByte((byte) (isselected ? 1 : 0));
    }

    public static final Parcelable.Creator<QModel> CREATOR =
            new Parcelable.Creator<QModel>() {
                @Override
                public QModel createFromParcel(Parcel in) {
                    return new QModel(in);
                }

                @Override
                public QModel[] newArray(int size) {
                    return new QModel[size];
                }
            };
    private QModel(Parcel in) {
        text=in.readString();
        author=in.readString();
    }

}
