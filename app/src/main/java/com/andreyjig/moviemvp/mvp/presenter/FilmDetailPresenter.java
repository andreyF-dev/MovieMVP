package com.andreyjig.moviemvp.mvp.presenter;

import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.mvp.view.FilmDetailView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class FilmDetailPresenter extends MvpPresenter<FilmDetailView> {

    private Film film;


}
