package com.andreyjig.moviemvp.utils;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.entities.holder.Genres;
import com.andreyjig.moviemvp.entities.holder.Header;
import com.andreyjig.moviemvp.ui.adapter.handler.FilmListAdapterChangeListener;

import java.util.ArrayList;

public class FilmListAdapterHelper {

    public static ArrayList<Object> createNewAdapterList(String genre, ArrayList<Film> films) {
        ArrayList<Object> newAdapterList = new ArrayList<>();
        newAdapterList.add(new Header(R.string.label_genres));
        newAdapterList.add(new Genres(MovieUtils.getGenres(films)));
        newAdapterList.add(new Header(R.string.label_films));
        newAdapterList.addAll(MovieUtils.getFilterFilm(genre, films));
        return newAdapterList;
    }

    public static void setChangeToList(ArrayList<Film> films, Film film, FilmListAdapterChangeListener listener){
        for (int index = 0; index < films.size(); index ++){
            Film cuurrentFilm = films.get(index);
            if (cuurrentFilm.getId() == film.getId()){
                films.set(index, film);
                listener.changedFilm(films);
                return;
            }
        }
        films.add(film);
        listener.changedFilm(films);
    }

    public static int getIndexOfGenres(ArrayList<Object> list){
        for (int index = 0; index < list.size(); index ++){
            if (list.get(index) instanceof Genres){
                return index;
            }
        }
        return 0;
    }
}
