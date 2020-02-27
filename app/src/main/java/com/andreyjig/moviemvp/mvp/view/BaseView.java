package com.andreyjig.moviemvp.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleTagStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface BaseView extends MvpView {
    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = "Title")
    void setTitle(int titleResId);
    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = "Title")
    void setTitle(String title);
    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = "Error")
    void showError(int errorResId);
    @StateStrategyType(value = AddToEndSingleTagStrategy.class, tag = "Error")
    void hideError();
}
