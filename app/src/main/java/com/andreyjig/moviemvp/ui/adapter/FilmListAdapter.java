package com.andreyjig.moviemvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.entities.holder.Genres;
import com.andreyjig.moviemvp.entities.holder.Header;
import com.andreyjig.moviemvp.ui.adapter.handler.FilmListAdapterCallback;
import com.andreyjig.moviemvp.ui.adapter.handler.GenresAdapterCallback;
import com.andreyjig.moviemvp.ui.adapter.holder.FilmHolder;
import com.andreyjig.moviemvp.ui.adapter.holder.GenresHolder;
import com.andreyjig.moviemvp.ui.adapter.holder.HeaderHolder;
import com.andreyjig.moviemvp.utils.FilmListAdapterDiffCallback;
import com.andreyjig.moviemvp.utils.FilmListAdapterHelper;

import java.util.ArrayList;

public class FilmListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements GenresAdapterCallback {

    private final int TYPE_HEADER = 0;
    private final int TYPE_GENRES = 1;
    private final int TYPE_FILM_ID = 2;
    private Context context;
    private ArrayList<Object> adapterList;
    private ArrayList<Film> films;
    private FilmListAdapterCallback callback;
    private String genre;

    public FilmListAdapter(Context context, ArrayList<Film> films, FilmListAdapterCallback callback) {
        this.context = context;
        this.callback = callback;
        this.films = films;
        adapterList = new ArrayList<>();
        setItems("");
    }

    public void setItems(String genre) {
        this.genre = genre;
        ArrayList<Object> newList = FilmListAdapterHelper.createNewAdapterList(genre, films);
        FilmListAdapterDiffCallback diffCallback = new
                FilmListAdapterDiffCallback(getData(), newList);
        DiffUtil.DiffResult filmDiffResult = DiffUtil.calculateDiff(diffCallback);
        setData(newList);
        filmDiffResult.dispatchUpdatesTo(this);
    }

    private void setData(ArrayList<Object> list){
        adapterList = list;
    }

    private ArrayList<Object> getData(){
        return adapterList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_HEADER:
                view = LayoutInflater.from(context).inflate(R.layout.item_header, parent, false);
                return new HeaderHolder(view);
            case TYPE_GENRES:
                view = LayoutInflater.from(context).inflate(R.layout.item_genres, parent, false);
                return new GenresHolder(view, context, this);
            case TYPE_FILM_ID:
                view = LayoutInflater.from(context).inflate(R.layout.item_film, parent, false);
                return new FilmHolder(view, callback);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case TYPE_HEADER:
                ((HeaderHolder)holder).bind((Header)adapterList.get(position));
                break;
            case TYPE_GENRES:
                ((GenresHolder)holder).bind((Genres)adapterList.get(position), genre);
                break;
            case TYPE_FILM_ID:
                ((FilmHolder)holder).bind((Film)adapterList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return adapterList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object object = adapterList.get(position);
        if (object instanceof Header){
            return TYPE_HEADER;
        } else if (object instanceof Genres){
            return TYPE_GENRES;
        } else if (object instanceof Film){
            return TYPE_FILM_ID;
        }
        return 0;
    }

    @Override
    public void setGenre(String genre) {
        callback.selectGenre(genre);
    }
}
