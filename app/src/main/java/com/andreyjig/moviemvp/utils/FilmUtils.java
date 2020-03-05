package com.andreyjig.moviemvp.utils;

import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.entities.holder.Genre;

import java.util.ArrayList;
import java.util.Collections;

public class FilmUtils {

    public static ArrayList<Genre> getFilterGenre(Genre currentGenre, ArrayList<Genre> genres) {
        ArrayList<Genre> result = new ArrayList<>();
        for (Genre genre : genres) {
            String name = genre.getName();
            Genre newGenre = new Genre(name);
            if (currentGenre != null && name.equals(currentGenre.getName())) {
                newGenre.setSelectedTrue();
            } else {
                newGenre.setSelectedFalse();
            }
            result.add(newGenre);
        }
        return result;
    }

    public static ArrayList<Genre> getGenres(ArrayList<Film> films) {
        ArrayList<String> genres = new ArrayList<>();
        for (Film film : films) {
            ArrayList<String> genresOfFilm = film.getGenres();
            for (String genre : genresOfFilm) {
                if (!genres.contains(genre)) {
                    genres.add(genre);
                }
            }
        }
        Collections.sort(genres);
        ArrayList<Genre> result = new ArrayList<>();
        for (String genre : genres) {
            result.add(new Genre(genre));
        }
        return result;
    }

    public static ArrayList<Film> getFilterFilm(Genre genre, ArrayList<Film> films) {
        if (genre == null) {
            return new ArrayList<>(films);
        }
        ArrayList<Film> result = new ArrayList<>();
        String name = genre.getName();
        for (Film film : films) {
            for (int currentGenre = 0; currentGenre < film.getGenres().size(); currentGenre++) {
                if (name.isEmpty() || film.getGenres().get(currentGenre).equals(name)) {
                    result.add(film);
                    break;
                }
            }
        }
        return result;
    }
}
