package com.andreyjig.moviemvp.utils;

import com.andreyjig.moviemvp.entities.Film;

import java.util.ArrayList;
import java.util.Collections;

public class MovieUtils {

    public static ArrayList<String> getGenres(ArrayList<Film> films) {
        ArrayList<String> result = new ArrayList<>();
        for (Film film : films) {
            ArrayList<String> genres = film.getGenres();
            for (String genre : genres) {
                if (!result.contains(genre)) {
                    result.add(genre);
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    public static ArrayList<String> getAddGenres(ArrayList<String> genres, Film film){
        ArrayList<String> newGenres = film.getGenres();
        for (String genre : newGenres) {
            if (!genres.contains(genre)) {
                genres.add(genre);
            }
        }
        return genres;
    }


    public static ArrayList<Film> getFilterFilm(String genre, ArrayList<Film> films) {
        ArrayList<Film> filmIds = new ArrayList<>();
        for (Film film: films) {
            for (int currentGenre = 0; currentGenre < film.getGenres().size(); currentGenre++) {
                if (genre.isEmpty() || film.getGenres().get(currentGenre).equals(genre)) {
                    filmIds.add(film);
                    break;
                }
            }
        }
        return filmIds;
    }
}
