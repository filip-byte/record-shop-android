package com.example.recordshop.ui.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recordshop.R;
import com.example.recordshop.databinding.ActivityMainBinding;
import com.example.recordshop.model.Album;
import com.example.recordshop.ui.addnewalbum.AddNewAlbumActivity;
import com.example.recordshop.ui.updatealbum.UpdateAlbum;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

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
        albumAdapter = new AlbumAdapter(albums, this, this);
        // ... and then set it to the recyclerView.
        recyclerView.setAdapter(albumAdapter);

        // Create a new LinearLayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // ... and set it to the RecyclerView.
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        albumAdapter.notifyDataSetChanged();

    }


    public void addAlbum(View view) {
        Intent intent = new Intent(MainActivity.this, AddNewAlbumActivity.class);
        MainActivity.this.startActivity(intent);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, UpdateAlbum.class);

        Album clickedAlbum = albums.get(position);
        intent.putExtra("selected_album", clickedAlbum);

        startActivity(intent);

    }

}