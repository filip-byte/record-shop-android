package com.example.recordshop.ui.addnewalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.recordshop.model.Album;
import com.example.recordshop.ui.mainactivity.MainActivity;
import com.example.recordshop.ui.mainactivity.MainActivityViewModel;

public class AddAlbumClickHandlers {

    private Album album;
    private Context context;
    private MainActivityViewModel viewModel ;

    public AddAlbumClickHandlers(Album album, Context context, MainActivityViewModel viewModel) {
        this.album = album;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void onSubmitButton(View view) {
        if (album.getTitle() == null || album.getTitle().isEmpty() ||
                album.getReleaseYear() == 0 ||
                album.getPriceInPence() == 0 || album.getGenre() == null ||
                album.getStock() == 0 || album.getAuthor().getName() == null ||
                album.getAuthor().getName().isEmpty()) {

            Toast.makeText(context, "All fields must be filled", Toast.LENGTH_SHORT).show();

        } else {

            Album newAlbum = new Album(album.getId(),
                    album.getTitle(),
                    album.getReleaseYear(),
                    album.getGenre(),
                    album.getPriceInPence(),
                    album.getStock(),
                    album.getAuthor());

            viewModel.addNewAlbum(newAlbum);

            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        }

    }

}

