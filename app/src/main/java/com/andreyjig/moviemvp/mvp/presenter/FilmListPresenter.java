package com.andreyjig.moviemvp.mvp.presenter;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.mvp.model.FilmListModel;
import com.andreyjig.moviemvp.mvp.model.handler.DataHandler;
import com.andreyjig.moviemvp.mvp.view.FilmListView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import java.util.ArrayList;

@InjectViewState
public class FilmListPresenter extends MvpPresenter<FilmListView> implements DataHandler<Film> {

    private FilmListModel model;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().updateTitle(R.string.app_name);
        model = new FilmListModel(this);
        model.getData();
    }

    @Override
    public void attachView(FilmListView view) {
        super.attachView(view);
    }

    @Override
    public void setData(ArrayList<Film> data) {
        getViewState().setFilmList(data);
    }

    @Override
    public void setErrorDownloaded(int errorStringId) {
        getViewState().showError(errorStringId);
    }

    public void setGenre(String genre){
        getViewState().updateGenre(genre);
    }
}
