package com.andreyjig.moviemvp.mvp.view;

import java.util.ArrayList;

public interface FilmDetailView extends BaseView {

    void showPoster(String posterUrl);

    void showLocalizedName(String localizedName);

    void showName(String name);

    void showYear(int year);

    void showRating(double rating);

    void showGenres(ArrayList<String> genres);

    void showDescription(String description);
}
