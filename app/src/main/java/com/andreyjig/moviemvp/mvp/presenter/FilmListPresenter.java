package com.andreyjig.moviemvp.mvp.presenter;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.entities.holder.Genre;
import com.andreyjig.moviemvp.mvp.model.FilmModel;
import com.andreyjig.moviemvp.mvp.view.FilmListView;
import com.andreyjig.moviemvp.utils.FilmUtils;
import com.arellomobile.mvp.InjectViewState;
import java.util.ArrayList;

@InjectViewState
public class FilmListPresenter extends BaseFilmPresenter<FilmListView, ArrayList<Film>> {

    private FilmModel model;
    private ArrayList<Film> films;
    private ArrayList<Genre> genres;
    private Genre genre;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        model = new FilmModel(this);
        model.getCashedFilm();
        loadData();
    }

    @Override
    public void loadData() {
        getViewState().hideError();
        model.downloadListFilms();
    }

    @Override
    public void setContent(ArrayList<Film> films) {
        this.films = films;
        genres = FilmUtils.getGenres(films);
        getViewState().setFilmList(genres, films);
    }

    @Override
    public int getTitleId() {
        return R.string.app_name;
    }

    @Override
    public boolean isCorrectData(ArrayList<Film> data) {
        if (data != null && data.size() > 0){
            return true;
        }
        return false;
    }

    public void setGenre(String genre) {
        if (this.genre != null && this.genre.getName().equals(genre)){
            this.genre = null;
        } else {
            this.genre = new Genre(genre);
        }
        genres = FilmUtils.getFilterGenre(this.genre, genres);
        ArrayList<Film> filteredFilms = FilmUtils.getFilterFilm(this.genre, films);
        getViewState().setFilmList(genres, filteredFilms);
    }
}
