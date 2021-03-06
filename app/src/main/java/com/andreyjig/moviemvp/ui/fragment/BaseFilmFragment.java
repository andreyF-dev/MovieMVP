package com.andreyjig.moviemvp.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.andreyjig.moviemvp.mvp.presenter.BaseFilmPresenter;
import com.andreyjig.moviemvp.ui.activity.handler.ActivityHandler;
import com.andreyjig.moviemvp.mvp.view.BaseView;
import com.andreyjig.moviemvp.ui.fragment.handler.ErrorHandler;
import com.arellomobile.mvp.MvpAppCompatFragment;

public abstract class BaseFilmFragment extends MvpAppCompatFragment
        implements BaseView, ErrorHandler {

    ActivityHandler activityHandler;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ActivityHandler){
            activityHandler = (ActivityHandler)context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        hideError();
        activityHandler.hideAppBarImage();
        activityHandler = null;
    }

    @Override
    public void updateTitle(int titleResId) {
        activityHandler.setAppBarTitle(getString(titleResId));
    }

    @Override
    public void updateTitle(String title) {
        activityHandler.setAppBarTitle(title);
    }

    @Override
    public void showError(int errorResId) {
        activityHandler.showErrorBar(getString(errorResId), this);
    }

    @Override
    public void hideError() {
        activityHandler.hideErrorBar();
    }

    @Override
    public void onOkErrorDialog(){
        getPresenter().onClickOkErrorDialog();
    }

    @Override
    public void onCancelErrorDialog(){
        getPresenter().onClickCancelErrorDialog();
    }

    public abstract BaseFilmPresenter getPresenter();
}
