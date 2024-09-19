package com.example.recordshop.service;

import com.example.recordshop.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlbumApiService {

    @GET("albums")
    public Call<List<Album>> getAllAlbums();

}
