package com.andreyjig.moviemvp.mvp.presenter;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.mvp.model.handler.DataHandler;
import com.andreyjig.moviemvp.mvp.view.BaseView;
import com.arellomobile.mvp.MvpPresenter;

public abstract class BaseFilmPresenter<T extends BaseView, D> extends MvpPresenter<T>
        implements DataHandler<D>{

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showPreviewScreen();
        getViewState().updateTitle(getTitleId());
    }

    @Override
    public void readyData(D data) {
        if (isCorrectData(data)){
            hideErrorDialog();
            getViewState().hidePreviewScreen();
            setContent(data);
        } else {
            callError(R.string.error_get_data);
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
