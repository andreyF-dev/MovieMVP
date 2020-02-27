package com.andreyjig.moviemvp.entities.shell;

import com.andreyjig.moviemvp.entities.Film;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class FilmShell {

    @SerializedName("films")
    @Expose
    private ArrayList<Film> films;

    public ArrayList<Film> getFilms() {
        return films;
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }
}
