package com.example.recordshop.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.recordshop.BR;

public class Album extends BaseObservable  implements Parcelable {
    private int id;
    private String title;
    private int releaseYear;
    private String genre;
    private int priceInPence;
    private int stock;
    private Author author;


    public Album(int id, String title, int releaseYear, String genre, int priceInPence, int stock, Author author) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.priceInPence = priceInPence;
        this.stock = stock;
        this.author = author;
    }

    public Album() {
    }

    protected Album(Parcel in) {
        id = in.readInt();
        title = in.readString();
        releaseYear = in.readInt();
        genre = in.readString();
        priceInPence = in.readInt();
        stock = in.readInt();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.releaseYear);
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    @Bindable
    public int getPriceInPence() {
        return priceInPence;
    }

    public void setPriceInPence(int priceInPence) {
        this.priceInPence = priceInPence;
        notifyPropertyChanged(BR.priceInPence);
    }

    @Bindable
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        notifyPropertyChanged(BR.stock);
    }

    @Bindable
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
        notifyPropertyChanged(BR.author);
    }

    @SuppressLint("DefaultLocale")
    public String formattedPrice() {
        return String.format("£%.2f", priceInPence / 100.0);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeInt(releaseYear);
        parcel.writeString(genre);
        parcel.writeInt(priceInPence);
        parcel.writeInt(stock);
    }
}
