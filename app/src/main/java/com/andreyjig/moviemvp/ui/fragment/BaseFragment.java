package com.andreyjig.moviemvp.ui.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.andreyjig.moviemvp.mvp.model.handler.ErrorHandler;
import com.andreyjig.moviemvp.ui.activity.handler.AppBarCustom;
import com.andreyjig.moviemvp.mvp.view.BaseView;
import com.arellomobile.mvp.MvpAppCompatFragment;

public class BaseFragment extends MvpAppCompatFragment implements BaseView {

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        hideError();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppBarCustom)getActivity()).hideAppBarImage();
    }

    @Override
    public void updateTitle(int titleResId) {
        ((AppBarCustom)getActivity()).setAppBarTitle(getString(titleResId));
    }

    @Override
    public void updateTitle(String title) {
        ((AppBarCustom)getActivity()).setAppBarTitle(title);
    }

    @Override
    public void showError(int errorResId, ErrorHandler handler) {
        ((AppBarCustom)getActivity()).showErrorBar(getString(errorResId), handler);
    }

    @Override
    public void hideError() {
        ((AppBarCustom)getActivity()).hideErrorBar();
    }
}
