package com.example.recordshop.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recordshop.databinding.AlbumItemBinding;
import com.example.recordshop.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private List<Album> albums;
    private Context context;
    private RecyclerViewInterface recyclerViewInterface;

    public AlbumAdapter(List<Album> albums, Context context, RecyclerViewInterface recyclerViewInterface) {
        this.albums = albums;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AlbumItemBinding albumItemBinding = AlbumItemBinding.inflate(LayoutInflater.from(
                parent.getContext()), parent, false);
        return new AlbumViewHolder(albumItemBinding, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albums.get(position);
        holder.albumItemBinding.setAlbum(album);
        holder.albumItemBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {

        private AlbumItemBinding albumItemBinding;

        public AlbumViewHolder(AlbumItemBinding albumItemBinding,
                               RecyclerViewInterface recyclerViewInterface) {
            super(albumItemBinding.getRoot());
            this.albumItemBinding = albumItemBinding;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}

