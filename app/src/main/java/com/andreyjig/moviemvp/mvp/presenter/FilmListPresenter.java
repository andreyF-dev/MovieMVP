package com.andreyjig.moviemvp.mvp.presenter;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.entities.holder.Genre;
import com.andreyjig.moviemvp.mvp.model.FilmListModel;
import com.andreyjig.moviemvp.mvp.model.handler.DataHandler;
import com.andreyjig.moviemvp.mvp.model.handler.ErrorHandler;
import com.andreyjig.moviemvp.mvp.view.FilmListView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import java.util.ArrayList;

@InjectViewState
public class FilmListPresenter extends MvpPresenter<FilmListView> implements DataHandler<Film>, ErrorHandler {

    private FilmListModel model;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().updateTitle(R.string.app_name);
        getViewState().showPreviewScreen();
        model = new FilmListModel(this);
        model.getData();
    }

    @Override
    public void attachView(FilmListView view) {
        super.attachView(view);
    }

    @Override
    public void setData(ArrayList<Film> data) {
        if (data != null && data.size()>0){
            getViewState().hidePreviewScreen();
            getViewState().setFilmList(data);
        }
    }

    @Override
    public void setErrorDownloaded(int errorStringId) {
        getViewState().showError(errorStringId, this);
    }

    public void setGenre(Genre genre){
        getViewState().updateGenre(genre);
    }

    @Override
    public void hideErrorDialog() {
        getViewState().hideError();
    }

    @Override
    public void retryAction() {
        getViewState().hideError();
        model.downloadData();
    }
}
