package com.example.recordshop.ui.updatealbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.recordshop.model.Album;
import com.example.recordshop.ui.mainactivity.MainActivity;
import com.example.recordshop.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumClickHandlers {

    private Album album;
    private MainActivityViewModel viewModel;
    private Long id;
    private Context context;

    public UpdateAlbumClickHandlers(Album album,
                                    MainActivityViewModel viewModel,
                                    Context context) {
        this.album = album;
        this.viewModel = viewModel;
        this.context = context;
        this.id = (long) album.getId();
    }

    public void onUpdateButton(View view) {
        Album updatedAlbum = new Album();
        updatedAlbum.setId(id != null ? id.intValue() : 0);

        updatedAlbum.setTitle(album.getTitle());
        updatedAlbum.setReleaseYear(album.getReleaseYear());
        updatedAlbum.setPriceInPence(album.getPriceInPence());
        updatedAlbum.setGenre(album.getGenre());
        updatedAlbum.setStock(album.getStock());

        if (updatedAlbum.getTitle().isEmpty()) {
            Toast.makeText(context, "Title cannot be empty",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (updatedAlbum.getGenre().isEmpty()) {
            Toast.makeText(context, "Genre cannot be empty",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (updatedAlbum.getReleaseYear() <= 0) {
            Toast.makeText(context, "Release Year must be a valid year",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (updatedAlbum.getPriceInPence() <= 0) {
            Toast.makeText(context, "Price must be greater than zero",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (updatedAlbum.getStock() < 0) {
            Toast.makeText(context, "Stock cannot be negative",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        viewModel.updateAlbum(id, updatedAlbum);

        context.startActivity(new Intent(context, MainActivity.class));

    }

    public void onDeleteButton(View view) {

        viewModel.deleteAlbum(id);

        context.startActivity(new Intent(context, MainActivity.class));

    }


}
