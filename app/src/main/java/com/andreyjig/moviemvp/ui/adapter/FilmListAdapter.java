package com.andreyjig.moviemvp.ui.adapter;

import android.content.Context;
import android.util.Log;
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
import com.andreyjig.moviemvp.ui.adapter.holder.FilmHolder;
import com.andreyjig.moviemvp.ui.adapter.holder.GenresHolder;
import com.andreyjig.moviemvp.ui.adapter.holder.HeaderHolder;
import com.andreyjig.moviemvp.utils.FilmsDiffUtilCallback;
import com.andreyjig.moviemvp.utils.MovieUtils;

import java.util.ArrayList;

public class FilmListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int TYPE_HEADER = 0;
    private final int TYPE_GENRES = 1;
    private final int TYPE_FILM = 2;
    private Context context;
    private ArrayList<Object> adapterList;
    private ArrayList<Film> films;
    private FilmListAdapterCallback callback;

    public FilmListAdapter(Context context, ArrayList<Film> films, FilmListAdapterCallback callback) {
        this.context = context;
        this.callback = callback;
        this.films = films;
        adapterList = new ArrayList<>();
        createAdapterList("");
    }

    public void createAdapterList(String genre) {
        ArrayList<Object> newAdapterList = new ArrayList<>();
        newAdapterList.add(new Header(R.string.label_genres));
        newAdapterList.add(new Genres(MovieUtils.getGenres(films)));
        newAdapterList.add(new Header(R.string.label_films));
        newAdapterList.addAll(MovieUtils.getFilterIndex(genre, films));
        /*FilmsDiffUtilCallback productDiffUtilCallback =
                new FilmsDiffUtilCallback(getData(), newAdapterList);
        DiffUtil.DiffResult productDiffResult = DiffUtil.calculateDiff(productDiffUtilCallback);
*/
        setData(newAdapterList);
        notifyDataSetChanged();
        //productDiffResult.dispatchUpdatesTo(this);
    }

    private ArrayList<Object> getData(){
        return adapterList;
    }

    private void setData(ArrayList<Object> objects){
        adapterList = objects;
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
                return new GenresHolder(view, context, callback);
            case TYPE_FILM:
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
                ((GenresHolder)holder).bind((Genres)adapterList.get(position));
                break;
            case TYPE_FILM:
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
            return TYPE_FILM;
        }
        return 0;
    }

    public interface FilmListAdapterCallback{
        void selectGenre(String genre);
        void selectFilm(int id);
    }
}
