package com.andreyjig.moviemvp.mvp.model.handler;

import com.andreyjig.moviemvp.entities.Film;
import java.util.ArrayList;

public interface FilmListHandler {

    void readyData(ArrayList<Film> films);
    void callError(int errorStringId);
}
