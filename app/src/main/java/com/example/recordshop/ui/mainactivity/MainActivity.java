package com.example.recordshop.ui.mainactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recordshop.R;
import com.example.recordshop.databinding.ActivityMainBinding;
import com.example.recordshop.model.Album;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private RecyclerView recyclerView;
    private AlbumAdapter albumAdapter;
    private MainActivityViewModel viewModel;

    private List<Album> albums;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        getAllAlbums();


    }

    private void getAllAlbums() {
        viewModel.getAlbums().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albumsFromLiveData) {
                albums = (List<Album>) albumsFromLiveData;

                displayInRecyclerView();
            }
        });
    }

    private void displayInRecyclerView() {
        recyclerView = binding.recyclerView;

        // Create this album adapter...
        albumAdapter = new AlbumAdapter(albums, this);
        // ... and then set it to the recyclerView.
        recyclerView.setAdapter(albumAdapter);

        // Create a new LinearLayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // ... and set it to the RecyclerView.
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        albumAdapter.notifyDataSetChanged();

    }


}