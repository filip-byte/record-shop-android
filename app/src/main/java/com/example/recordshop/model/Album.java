package com.example.recordshop.model;

import android.annotation.SuppressLint;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.recordshop.BR;

public class Album extends BaseObservable {
    private int id;
    private String title;
    private int releaseYear;
    private Genre genre;
    private int priceInPence;
    private int stock;
    private Author author;


    public Album(int id, String title, int releaseYear, Genre genre, int priceInPence, int stock, Author author) {
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
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
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

    public String stockDescription(){
        return stock + " in stock";
    }
}
