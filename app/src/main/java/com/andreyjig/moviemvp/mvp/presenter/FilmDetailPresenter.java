package com.andreyjig.moviemvp.mvp.presenter;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.mvp.model.FilmModel;
import com.andreyjig.moviemvp.mvp.view.FilmDetailView;
import com.andreyjig.moviemvp.ui.fragment.FilmDetailFragmentArgs;
import com.arellomobile.mvp.InjectViewState;

@InjectViewState
public class FilmDetailPresenter extends BaseFilmPresenter<FilmDetailView, Film> {

    private FilmModel model;
    private int id;

    public FilmDetailPresenter (FilmDetailFragmentArgs args){
        id = args.getId();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        model = new FilmModel(this);
        loadData();
    }

    @Override
    public void setContent(Film film) {
        getViewState().showPoster(film.getImageUrl());
        getViewState().showLocalizedName(film.getLocalizedName());
        getViewState().showName(film.getName());
        getViewState().showYear(film.getYear());
        getViewState().showGenres(film.getGenres());
        getViewState().showRating(film.getRating());
        getViewState().showDescription(film.getDescription());
    }

    @Override
    public int getTitleId() {
        return R.string.title_description;
    }

    @Override
    public boolean isCorrectData(Film data) {
        if (data != null){
            return true;
        }
        return false;
    }

    public void loadData() {
        getViewState().hideError();
        model.getFilm(id);
    }
}
