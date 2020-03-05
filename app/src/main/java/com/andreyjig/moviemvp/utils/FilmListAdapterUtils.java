package com.andreyjig.moviemvp.utils;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.entities.holder.Genre;
import com.andreyjig.moviemvp.entities.holder.Header;

import java.util.ArrayList;
import java.util.Collections;

public class FilmListAdapterUtils {

    public static int EMPTY_GENRE = -1;

    public static int getIndexGenre(ArrayList<Object> list, Genre genre){
        for (int index = 0; index < list.size(); index++){
            Object object = list.get(index);
            if ((genre != null) && (object instanceof Genre) &&(genre.equals(object))){
                return index;
            }
        }
        return EMPTY_GENRE;
    }

    public static ArrayList<Object> generateAdapterList(Genre genre, ArrayList<Film> films) {
        ArrayList<Object> newAdapterList = new ArrayList<>();
        newAdapterList.add(new Header(R.string.label_genres));
        newAdapterList.addAll(getGenres(films));
        newAdapterList.add(new Header(R.string.label_films));
        newAdapterList.addAll(getFilterFilm(genre, films));
        return newAdapterList;
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

    public static ArrayList<Film> getFilterFilm(Genre sortGenre, ArrayList<Film> films) {
        ArrayList<Film> result = new ArrayList<>();
        String genre = sortGenre.getName();
        for (Film film: films) {
            for (int currentGenre = 0; currentGenre < film.getGenres().size(); currentGenre++) {
                if (genre.isEmpty() || film.getGenres().get(currentGenre).equals(genre)) {
                    result.add(film);
                    break;
                }
            }
        }
        return result;
    }
}
