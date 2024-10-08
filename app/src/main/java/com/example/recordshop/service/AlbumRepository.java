package com.example.recordshop.service;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.recordshop.model.Album;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {

    private MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public AlbumRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<List<Album>> call = albumApiService.getAllAlbums();

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(@NonNull Call<List<Album>> call,
                                   @NonNull Response<List<Album>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Album> allAlbums = response.body();
                    mutableLiveData.setValue(allAlbums);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Album>> call, @NonNull Throwable t) {
                Log.e("GET HTTP REQUEST FAILED", Objects.requireNonNull(
                        t.getMessage()));
            }
        });
        return mutableLiveData;
    }


    public void addAlbum(Album newAlbum) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<Album> call = albumApiService.createAlbum(newAlbum);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(@NonNull Call<Album> call, @NonNull Response<Album> response) {

                Toast toast;
                if (response.isSuccessful() && response.body() != null) {
                    toast = Toast.makeText(application, "Added successfully!",
                            Toast.LENGTH_SHORT);
                } else {
                    toast = Toast.makeText(application, "Failed to add",
                            Toast.LENGTH_LONG);
                }
                toast.show();
            }

            @Override
            public void onFailure(@NonNull Call<Album> call, Throwable t) {

                Toast toast = Toast.makeText(
                        application,
                        "Request failed: " + t.getMessage(),
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });


    }

    public void updateAlbum(Long id, Album album) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<Album> call = albumApiService.updateAlbum(id, album);

        call.enqueue(new Callback<Album>() {

            Toast toast;

            @Override
            public void onResponse(@NonNull Call<Album> call, @NonNull Response<Album> response) {
                if (response.isSuccessful()) {
                    toast = Toast.makeText(application, "Album updated!",
                            Toast.LENGTH_SHORT);
                } else {
                    toast = Toast.makeText(application, "Failed to update.",
                            Toast.LENGTH_LONG);
                }
                toast.show();
            }

            @Override
            public void onFailure(@NonNull Call<Album> call, @NonNull Throwable t) {
                Toast toast = Toast.makeText(
                        application,
                        "Request failed: " + t.getMessage(),
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public void deleteAlbum(Long id) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<Void> call = albumApiService.deleteAlbum(id);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {

                Toast toast;

                if (response.isSuccessful()) {
                    toast = Toast.makeText(application, "Album deleted!",
                            Toast.LENGTH_SHORT);
                } else {
                    toast = Toast.makeText(application, "Unable to delete.",
                            Toast.LENGTH_LONG);
                }
                toast.show();

            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                Toast toast = Toast.makeText(
                        application,
                        "Request failed: " + t.getMessage(),
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

}
