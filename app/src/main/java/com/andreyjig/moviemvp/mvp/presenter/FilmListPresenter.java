package com.andreyjig.moviemvp.mvp.presenter;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.entities.holder.Genre;
import com.andreyjig.moviemvp.mvp.model.FilmListModel;
import com.andreyjig.moviemvp.mvp.view.FilmListView;
import com.arellomobile.mvp.InjectViewState;
import java.util.ArrayList;

@InjectViewState
public class FilmListPresenter extends BasePresenter<FilmListView, ArrayList<Film>> {

    public void setGenre(Genre genre){
        getViewState().updateGenre(genre);
    }

    @Override
    public void setModel() {
        model = new FilmListModel(this);
    }

    @Override
    public void setContent(ArrayList<Film> films) {
        getViewState().setFilmList(films);
    }

    @Override
    public int getTitleId() {
        return R.string.app_name;
    }
}
