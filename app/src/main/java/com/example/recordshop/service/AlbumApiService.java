package com.example.recordshop.service;

import com.example.recordshop.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlbumApiService {

    @GET("albums")
    public Call<List<Album>> getAllAlbums();

    @POST("albums")
    public Call<Album> createAlbum(@Body Album album);

    @PUT("albums/{id}")
    public Call<Album> updateAlbum(@Path("id") Long id, @Body Album album);

    @DELETE("albums/{id}")
    public Call<Void> deleteAlbum(@Path("id") Long id);

}
