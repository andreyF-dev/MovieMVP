package com.andreyjig.moviemvp.ui.adapter.holder;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.holder.Genres;
import com.andreyjig.moviemvp.ui.adapter.GenresHolderAdapter;
import com.andreyjig.moviemvp.ui.adapter.handler.GenresAdapterCallback;

public class GenresHolder extends RecyclerView.ViewHolder {

    private RecyclerView genresRecyclerView;
    private Context context;
    private GenresAdapterCallback callback;

    public GenresHolder(@NonNull View itemView, Context context, GenresAdapterCallback callback) {
        super(itemView);
        this.context = context;
        this.callback = callback;
        genresRecyclerView = itemView.findViewById(R.id.genres_recyclerview);
        genresRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        genresRecyclerView.setHasFixedSize(true);
    }

    public void bind (Genres genres, String genre){
        GenresHolderAdapter adapter = new GenresHolderAdapter(context, genres.getGenres(), genre, callback);
        genresRecyclerView.setAdapter(adapter);
    }
}
