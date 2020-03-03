package com.andreyjig.moviemvp.ui.adapter.handler;

import com.andreyjig.moviemvp.entities.Film;

import java.util.ArrayList;

public interface FilmListAdapterChangeListener {
    void changedFilm (ArrayList<Film> films);
}
