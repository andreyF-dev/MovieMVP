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

public class FilmListModel{

    private DataHandler<Film> presenterCallback;

    public FilmListModel (DataHandler<Film> callback){
        presenterCallback = callback;
    }

    public void getData(){
        presenterCallback.setData(getCashedFilm());
        downloadData();
    }

    public void downloadData(){
        NetworkService.getInstance()
                .getJSONApi()
                .getFilms()
                .enqueue(new Callback<FilmShell>() {
                    @Override
                    public void onResponse(Call<FilmShell> call, Response<FilmShell> response) {
                        try {
                            ArrayList<Film> films = response.body().getFilms();
                            presenterCallback.setData(films);
                            RealmHelper.getInstance().cashedFilms(films);
                        } catch (Exception e){
                            e.printStackTrace();
                            presenterCallback.setErrorDownloaded(R.string.error_get_data);
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmShell> call, Throwable t) {
                        t.printStackTrace();
                        presenterCallback.setErrorDownloaded(R.string.error_no_connection);
                    }
                });
    }

    private ArrayList<Film> getCashedFilm(){
        return RealmHelper.getInstance().getAllFilms();
    }

}
