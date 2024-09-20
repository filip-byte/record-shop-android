package com.example.recordshop.ui.addnewalbum;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.recordshop.R;
import com.example.recordshop.databinding.ActivityAddNewAlbumBinding;
import com.example.recordshop.model.Album;
import com.example.recordshop.model.Author;
import com.example.recordshop.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumActivity extends AppCompatActivity {

    // What do we need?
    // 1. binding, 2. viewModel, 3. album to hold data coming in.
    private ActivityAddNewAlbumBinding binding;
    private MainActivityViewModel viewModel;
    private Album album;
    private Author author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_add_new_album);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        author = new Author();
        album = new Album();
        album.setAuthor(author);

        AddAlbumClickHandlers handlers = new AddAlbumClickHandlers( album, this, viewModel);

        binding.setAlbum(album);
        binding.setHandler(handlers);

    }
}