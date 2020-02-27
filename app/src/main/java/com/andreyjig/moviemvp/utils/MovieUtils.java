package com.andreyjig.moviemvp.utils;

import com.andreyjig.moviemvp.entities.Film;

import java.util.ArrayList;

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

        return result;
    }

    public static ArrayList<Film> getFilterIndex(String genre, ArrayList<Film> films) {
        if (genre.isEmpty()) {
            return films;
        } else {
            ArrayList<Film> filterMovies = new ArrayList<>();
            for (int index = 0; index < films.size(); index++) {
                Film film = films.get(index);
                for (int currentGenre = 0; currentGenre < film.getGenres().size(); currentGenre++) {
                    if (film.getGenres().get(currentGenre).equals(genre)) {
                        filterMovies.add(film);
                        break;
                    }
                }
            }
            return filterMovies;
        }
        }
    }
