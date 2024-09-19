package com.example.recordshop.service;

import com.example.recordshop.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AlbumApiService {

    @GET("albums")
    public Call<List<Album>> getAllAlbums();

    @POST("albums")
    public Call<Album> createAlbum(@Body Album album);

}
