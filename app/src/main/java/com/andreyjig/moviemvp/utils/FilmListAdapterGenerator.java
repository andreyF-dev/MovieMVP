package com.andreyjig.moviemvp.utils;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.entities.holder.Genre;
import com.andreyjig.moviemvp.entities.holder.Header;
import java.util.ArrayList;

public class FilmListAdapterGenerator {

    public static ArrayList<Object> generateAdapterList(ArrayList<Genre> genres, ArrayList<Film> films) {
        ArrayList<Object> newAdapterList = new ArrayList<>();
        newAdapterList.add(new Header(R.string.label_genres));
        newAdapterList.addAll(genres);
        newAdapterList.add(new Header(R.string.label_films));
        newAdapterList.addAll(films);
        return newAdapterList;
    }
}
