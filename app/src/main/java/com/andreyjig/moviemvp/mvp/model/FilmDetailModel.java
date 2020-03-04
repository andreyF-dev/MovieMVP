package com.andreyjig.moviemvp.mvp.model;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.database.RealmHelper;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.mvp.model.handler.DataHandler;

public class FilmDetailModel extends BaseModel<Film>{

    private int id;

    public FilmDetailModel(DataHandler<Film> callback, int id) {
        super(callback);
        this.id = id;
    }

    @Override
    public void getData() {
        Film film = RealmHelper.getInstance().getFilmById(id);
        callback.setData(film);
    }
}
