package com.andreyjig.moviemvp.mvp.presenter;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.database.RealmHelper;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.mvp.view.FilmDetailView;
import com.andreyjig.moviemvp.ui.fragment.FilmDetailFragmentArgs;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class FilmDetailPresenter extends MvpPresenter<FilmDetailView> {

    private Film film;
    private int id;

    public FilmDetailPresenter (FilmDetailFragmentArgs args){
        id = args.getId();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        film = RealmHelper.getInstance().getFilmById(id);
        getViewState().updateTitle(R.string.description);
        showFilmDetail();
    }

    private void showFilmDetail(){
        getViewState().showPoster(film.getImageUrl());
        getViewState().showLocalizedName(film.getLocalizedName());
        getViewState().showName(film.getName());
        getViewState().showYear(film.getYear());
        getViewState().showGenres(film.getGenres());
        getViewState().showRating(film.getRating());
        getViewState().showDescription(film.getDescription());
    }
}
