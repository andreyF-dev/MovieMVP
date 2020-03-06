package com.andreyjig.moviemvp.mvp.presenter;

import com.andreyjig.moviemvp.mvp.view.BaseView;
import com.arellomobile.mvp.MvpPresenter;

public abstract class BaseFilmPresenter<T extends BaseView> extends MvpPresenter<T> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().updateTitle(getTitleId());
    }

    public void hideErrorDialog() {
        getViewState().hideError();
    }

    public abstract int getTitleId();
}
