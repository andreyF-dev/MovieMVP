package com.andreyjig.moviemvp.utils;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.entities.holder.Genre;
import com.andreyjig.moviemvp.entities.holder.Header;

import java.util.ArrayList;

public class FilmListAdapterHelper {

    public static ArrayList<Object> createNewAdapterList(Genre genre, ArrayList<Film> films) {
        ArrayList<Object> newAdapterList = new ArrayList<>();
        newAdapterList.add(new Header(R.string.label_genres));
        newAdapterList.addAll(FilmUtils.getGenres(films));
        newAdapterList.add(new Header(R.string.label_films));
        newAdapterList.addAll(FilmUtils.getFilterFilm(genre, films));
        return newAdapterList;
    }

}
