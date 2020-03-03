package com.andreyjig.moviemvp.entities.holder;

import android.util.Log;

import java.util.ArrayList;
import java.util.Objects;

public class Genres {

    private ArrayList<String> genres;

    public Genres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        Log.d("Retrofit", "equals run");
        if (this == o) return true;
        if (!(o instanceof Genres)) return false;
        Genres genres1 = (Genres) o;
        Log.d("Retrofit", String.valueOf(genres.equals(genres1.genres)));
        return Objects.equals(genres, genres1.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genres);
    }

    @Override
    public String toString() {
        return "Genres{" +
                "genres=" + genres +
                '}';
    }
}
