package com.andreyjig.moviemvp.ui.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.andreyjig.moviemvp.mvp.model.handler.ErrorHandler;
import com.andreyjig.moviemvp.ui.activity.handler.ActivityHandler;
import com.andreyjig.moviemvp.mvp.view.BaseView;
import com.arellomobile.mvp.MvpAppCompatFragment;

public abstract class BaseFragment extends MvpAppCompatFragment implements BaseView {

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        hideError();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((ActivityHandler)getActivity()).hideAppBarImage();
    }

    @Override
    public void showPreviewScreen() {
        hideContent();
        ((ActivityHandler)getActivity()).showPreviewScreen();
    }

    @Override
    public void hidePreviewScreen() {
        showContent();
        ((ActivityHandler)getActivity()).hidePreviewScreen();
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
    public void showError(int errorResId, ErrorHandler handler) {
        ((ActivityHandler)getActivity()).showErrorBar(getString(errorResId), handler);
    }

    @Override
    public void hideError() {
        ((ActivityHandler)getActivity()).hideErrorBar();
    }

    public abstract void hideContent();

    public abstract void showContent();
}
