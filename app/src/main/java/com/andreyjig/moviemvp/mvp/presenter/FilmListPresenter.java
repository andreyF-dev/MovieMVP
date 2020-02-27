package com.andreyjig.moviemvp.mvp.presenter;

import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.mvp.model.FilmListModel;
import com.andreyjig.moviemvp.mvp.model.handler.DataHandler;
import com.andreyjig.moviemvp.mvp.view.FilmListView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import java.util.ArrayList;

@InjectViewState
public class FilmListPresenter extends MvpPresenter<FilmListView> implements DataHandler<ArrayList<Film>> {

    private FilmListModel model;
    private String genre;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        model = new FilmListModel();
        model.getData(this);
    }

    @Override
    public void attachView(FilmListView view) {
        super.attachView(view);
    }

    @Override
    public void setDownloadedData(ArrayList<Film> data) {
        getViewState().setFilmList(data);
    }

    @Override
    public void setErrorDownloaded(int errorStringId) {
        getViewState().showError(errorStringId);
    }

    public void setGenre(String genre){
        this.genre = genre;
        getViewState().updateGenre(genre);
    }
}
