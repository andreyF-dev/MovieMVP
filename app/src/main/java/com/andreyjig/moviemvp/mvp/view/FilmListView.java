package com.andreyjig.moviemvp.mvp.view;

import com.andreyjig.moviemvp.entities.Film;
import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleTagStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.ArrayList;

public interface FilmListView extends MvpView, BaseView {

    @StateStrategyType(AddToEndStrategy.class)
    void setFilmList(ArrayList<Film> films);
    @StateStrategyType(AddToEndSingleStrategy.class)
    void updateGenre(String genre);
}
