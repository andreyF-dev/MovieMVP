package com.andreyjig.moviemvp.mvp.model;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.database.RealmHelper;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.entities.shell.FilmShell;
import com.andreyjig.moviemvp.mvp.model.handler.DataHandler;
import com.andreyjig.moviemvp.network.NetworkService;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmModel {

    private DataHandler callback;

    public FilmModel(DataHandler callback) {
        this.callback = callback;
    }

    public void getFilm(int id) {
        Film film = RealmHelper.getInstance().getFilmById(id);
        callback.setData(film);
    }

    public void downloadListFilms() {
        NetworkService.getInstance()
                .getJSONApi()
                .getFilms()
                .enqueue(new Callback<FilmShell>() {
                    @Override
                    public void onResponse(Call<FilmShell> call, Response<FilmShell> response) {
                        try {
                            ArrayList<Film> films = response.body().getFilms();
                            callback.setData(films);
                            RealmHelper.getInstance().casheFilms(films);
                        } catch (Exception e) {
                            e.printStackTrace();
                            callback.callError(R.string.error_get_data);
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmShell> call, Throwable t) {
                        t.printStackTrace();
                        callback.callError(R.string.error_no_connection);
                    }
                });
    }

    public void getCashedFilm() {
        ArrayList<Film> films = RealmHelper.getInstance().getAllFilms();
        callback.setData(films);
    }
}
