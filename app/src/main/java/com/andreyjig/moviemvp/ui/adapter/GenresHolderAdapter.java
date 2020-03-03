package com.andreyjig.moviemvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.andreyjig.moviemvp.ui.adapter.holder.GenreHolder;

import java.util.ArrayList;

public class GenresHolderAdapter extends RecyclerView.Adapter<GenreHolder>
        implements GenreHolder.GenreHolderCallback {

    private Context context;
    private ArrayList<String> genres;
    private String currentGenre;
    private GenresAdapterCallback callback;

    public GenresHolderAdapter(Context context, ArrayList<String> genres, String currentGenre, GenresAdapterCallback callback) {
        this.context = context;
        this.genres = genres;
        this.currentGenre = currentGenre;
        this.callback = callback;
    }

    @NonNull
    @Override
    public GenreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new GenreHolder(view, context,this);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreHolder holder, int position) {
        String genre = genres.get(position);
        holder.bind(genre);
        if (currentGenre.equals(genre)){
            holder.selectHolder();
        } else {
            holder.cancelHolder();
        }
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }

    @Override
    public void onClickGenre(String genre) {
        int oldIndex = genres.indexOf(currentGenre);
        if (currentGenre.equals(genre)){
            currentGenre = "";
        } else {
            currentGenre = genre;
            notifyItemChanged(genres.indexOf(genre));
        }
        notifyItemChanged(oldIndex);
        callback.setGenre(currentGenre);


    }


    public interface GenresAdapterCallback {
        void setGenre(String genre);
    }
}
