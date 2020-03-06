package com.andreyjig.moviemvp.mvp.presenter;

import com.andreyjig.moviemvp.mvp.model.handler.DataHandler;
import com.andreyjig.moviemvp.mvp.view.BaseView;
import com.arellomobile.mvp.MvpPresenter;

public abstract class BaseFilmPresenter<T extends BaseView, D> extends MvpPresenter<T>
        implements DataHandler<D>{

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().updateTitle(getTitleId());
    }

    @Override
    public void readyData(D data) {
        if (isCorrectData(data)){
            hideErrorDialog();
            setContent(data);
        }
    }

    @Override
    public void callError(int errorStringId) {
        getViewState().showError(errorStringId);
    }

    public void hideErrorDialog() {
        getViewState().hideError();
    }

    public abstract void setContent(D data);
    public abstract int getTitleId();
    public abstract boolean isCorrectData(D data);
}
