package com.andreyjig.moviemvp.ui.activity.handler;

import com.andreyjig.moviemvp.mvp.model.handler.ErrorHandler;

public interface ActivityHandler {
    void setAppBarImage(String url);
    void hideAppBarImage();
    void setAppBarTitle(String title);
    void showErrorBar(String text, ErrorHandler handler);
    void hideErrorBar();
    void showPreviewScreen();
    void hidePreviewScreen();
}
