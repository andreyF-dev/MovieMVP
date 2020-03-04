package com.andreyjig.moviemvp.mvp.view;

import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.entities.holder.Genre;
import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleTagStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.ArrayList;

public interface FilmListView extends MvpView, BaseView {

    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = "Preview")
    void showPreviewScreen();
    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = "Preview")
    void hidePreviewScreen();
    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = "Films")
    void setFilmList(ArrayList<Film> films);
    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = "Genre")
    void updateGenre(Genre genre);
}
