package com.andreyjig.moviemvp.mvp.presenter;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.mvp.model.FilmModel;
import com.andreyjig.moviemvp.mvp.view.FilmDetailView;
import com.arellomobile.mvp.InjectViewState;

@InjectViewState
public class FilmDetailPresenter extends BaseFilmPresenter<FilmDetailView> {

    private FilmModel model;
    private int id;
    private Film film;

    public FilmDetailPresenter (int id){
        this.id = id;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        model = new FilmModel();
        loadData();
        setContent();
    }

    @Override
    public int getTitleId() {
        return R.string.title_description;
    }

    @Override
    public void onClickOkErrorDialog() {
        getViewState().hideError();
        loadData();
    }

    private void setContent() {
        if (film == null){
            getViewState().showError(R.string.error_database_no_film);
        } else {
            getViewState().showPoster(film.getImageUrl());
            getViewState().showLocalizedName(film.getLocalizedName());
            getViewState().showName(film.getName());
            getViewState().showYear(film.getYear());
            getViewState().showGenres(film.getGenres());
            getViewState().showRating(film.getRating());
            getViewState().showDescription(film.getDescription());
        }
    }

    public void loadData() {
        film = model.getFilm(id);
    }
}
