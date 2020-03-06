package com.andreyjig.moviemvp.ui.fragment;

import android.os.Bundle;
import com.andreyjig.moviemvp.ui.activity.handler.ActivityHandler;
import com.andreyjig.moviemvp.mvp.view.BaseView;
import com.andreyjig.moviemvp.ui.fragment.handler.ErrorHandler;
import com.arellomobile.mvp.MvpAppCompatFragment;

public abstract class BaseFilmFragment extends MvpAppCompatFragment
        implements BaseView, ErrorHandler {

    ActivityHandler activityHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHandler = (ActivityHandler)getActivity();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hideError();
        activityHandler.hideAppBarImage();
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
    public abstract void onOkErrorDialog();

    @Override
    public abstract void onCancelErrorDialog();

}
