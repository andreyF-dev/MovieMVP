package com.andreyjig.moviemvp.mvp.presenter;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.entities.holder.Genre;
import com.andreyjig.moviemvp.mvp.model.FilmModel;
import com.andreyjig.moviemvp.mvp.model.handler.FilmListHandler;
import com.andreyjig.moviemvp.mvp.view.FilmListView;
import com.andreyjig.moviemvp.utils.FilmUtils;
import com.arellomobile.mvp.InjectViewState;
import java.util.ArrayList;

@InjectViewState
public class FilmListPresenter extends BaseFilmPresenter<FilmListView> implements FilmListHandler {

    private FilmModel model;
    private ArrayList<Film> films;
    private ArrayList<Genre> genres;
    private Genre genre;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showPreviewScreen();
        model = new FilmModel();
        films = model.getCashedFilms();
        setContent(films);
        loadData();
    }

    @Override
    public int getTitleId() {
        return R.string.app_name;
    }

    @Override
    public void readyData(ArrayList<Film> films) {
        setContent(films);
    }

    @Override
    public void callError(int errorStringId) {
        getViewState().showError(errorStringId);
    }

    private void loadData(){
        getViewState().hideError();
        model.downloadListFilms(this);
    }

    @Override
    public void onClickOkErrorDialog() {
        loadData();
    }

    private void setContent(ArrayList<Film> films) {
        if (isCorrectData(films)) {
            this.films = films;
            getViewState().hidePreviewScreen();
            getViewState().hideError();
            genres = FilmUtils.getGenres(films);
            getViewState().setFilmList(genres, films);
        }
    }

    private boolean isCorrectData(ArrayList<Film> data) {
        return data != null && data.size() > 0;
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
