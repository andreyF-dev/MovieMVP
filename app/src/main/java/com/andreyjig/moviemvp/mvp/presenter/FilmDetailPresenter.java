package com.andreyjig.moviemvp.mvp.presenter;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.mvp.model.FilmDetailModel;
import com.andreyjig.moviemvp.mvp.view.FilmDetailView;
import com.andreyjig.moviemvp.ui.fragment.FilmDetailFragmentArgs;
import com.arellomobile.mvp.InjectViewState;

@InjectViewState
public class FilmDetailPresenter extends BasePresenter<FilmDetailView, Film>{

    private int id;

    public FilmDetailPresenter (FilmDetailFragmentArgs args){
        id = args.getId();
    }

    @Override
    public void setModel() {
        model = new FilmDetailModel(this, id);
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
}
