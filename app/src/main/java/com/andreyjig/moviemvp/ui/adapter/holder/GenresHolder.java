package com.andreyjig.moviemvp.ui.adapter.holder;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.holder.Genres;
import com.andreyjig.moviemvp.ui.adapter.GenresHolderAdapter;

public class GenresHolder extends RecyclerView.ViewHolder {

    private RecyclerView genresRecyclerView;
    private Context context;
    private GenresHolderAdapter adapter;
    private String currentGenre;
    private GenresHolderAdapter.GenresAdapterCallback callback;

    public GenresHolder(@NonNull View itemView, Context context, GenresHolderAdapter.GenresAdapterCallback callback) {
        super(itemView);
        this.context = context;
        this.callback = callback;
        genresRecyclerView = itemView.findViewById(R.id.genres_recyclerview);
    }

    public void bind (Genres genres, String genre){
        currentGenre = genre;
        adapter = new GenresHolderAdapter(context, genres.getGenres(), currentGenre, callback);
        genresRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        genresRecyclerView.setAdapter(adapter);
    }
}
