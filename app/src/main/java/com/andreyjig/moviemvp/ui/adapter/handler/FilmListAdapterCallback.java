package com.andreyjig.moviemvp.ui.adapter.handler;

import com.andreyjig.moviemvp.entities.holder.Genre;

public interface FilmListAdapterCallback{
    void setGenre(Genre genre);
    void selectFilm(int id);
}