package com.example.recordshop.ui.addnewalbum;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.recordshop.R;
import com.example.recordshop.databinding.ActivityAddNewAlbumBinding;
import com.example.recordshop.model.Album;
import com.example.recordshop.model.Author;
import com.example.recordshop.ui.mainactivity.MainActivityViewModel;

import java.sql.Array;
import java.util.ArrayList;

public class AddNewAlbumActivity extends AppCompatActivity {

    private ActivityAddNewAlbumBinding binding;
    private MainActivityViewModel viewModel;
    private Album album;
    private Author author;
    private AutoCompleteTextView genreDropdown;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        author = new Author();
        album = new Album();
        album.setAuthor(author);

        AddAlbumClickHandlers handlers = new AddAlbumClickHandlers(album, this, viewModel);

        binding.setAlbum(album);
        binding.setHandler(handlers);

        genreDropdown = binding.genreExposedDropdown;

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.genre_array,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        genreDropdown.setAdapter(adapter);

    }
}