package com.andreyjig.moviemvp.mvp.view;

import com.andreyjig.moviemvp.mvp.model.handler.ErrorHandler;
import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleTagStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface BaseView extends MvpView {
    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = "Title")
    void updateTitle(int titleResId);
    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = "Title")
    void updateTitle(String title);
    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = "Error")
    void showError(int errorResId, ErrorHandler handler);
    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = "Error")
    void hideError();
}
