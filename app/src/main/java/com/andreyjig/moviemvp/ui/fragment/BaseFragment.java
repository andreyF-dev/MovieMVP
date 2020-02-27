package com.andreyjig.moviemvp.ui.fragment;

import com.andreyjig.moviemvp.mvp.view.BaseView;
import com.arellomobile.mvp.MvpAppCompatFragment;

public class BaseFragment extends MvpAppCompatFragment implements BaseView {
    @Override
    public void setTitle(int titleResId) {

    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void showError(int errorResId) {

    }

    @Override
    public void hideError() {

    }
}
