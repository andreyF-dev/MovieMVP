package com.andreyjig.moviemvp.ui.fragment;

import com.andreyjig.moviemvp.mvp.presenter.BaseFilmPresenter;
import com.andreyjig.moviemvp.ui.activity.handler.ActivityHandler;
import com.andreyjig.moviemvp.mvp.view.BaseView;
import com.andreyjig.moviemvp.ui.fragment.handler.ErrorHandler;
import com.arellomobile.mvp.MvpAppCompatFragment;

public abstract class BaseFilmFragment extends MvpAppCompatFragment
        implements BaseView, ErrorHandler {

    public BaseFilmPresenter presenter;

    @Override
    public void onDestroy() {
        super.onDestroy();
        hideError();
        ((ActivityHandler)getActivity()).hideAppBarImage();
    }

    @Override
    public void updateTitle(int titleResId) {
        ((ActivityHandler)getActivity()).setAppBarTitle(getString(titleResId));
    }

    @Override
    public void updateTitle(String title) {
        ((ActivityHandler)getActivity()).setAppBarTitle(title);
    }

    @Override
    public void showError(int errorResId) {
        ((ActivityHandler)getActivity()).showErrorBar(getString(errorResId), this);
    }

    @Override
    public void hideError() {
        ((ActivityHandler)getActivity()).hideErrorBar();
    }

    @Override
    public void onOkErrorDialog() {
       retryLoad();
    }

    @Override
    public void onCancelErrorDialog() {
        cancelReLoad();
    }

    public abstract void retryLoad();
    public abstract void cancelReLoad();
}
