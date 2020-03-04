package com.andreyjig.moviemvp.ui.activity.handler;

import com.andreyjig.moviemvp.mvp.model.handler.ErrorHandler;

public interface AppBarCustom {
    void setAppBarImage(String url);
    void hideAppBarImage();
    void setAppBarTitle(String title);
    void showErrorBar(String text, ErrorHandler handler);
    void hideErrorBar();
}
