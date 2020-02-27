package com.andreyjig.moviemvp.mvp.model;

import android.util.Log;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.entities.shell.FilmShell;
import com.andreyjig.moviemvp.mvp.model.handler.DataHandler;
import com.andreyjig.moviemvp.network.NetworkService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmListModel {

    public void getData(DataHandler<ArrayList<Film>> callback){
        Log.d("MovieMVP", "load list film");
        NetworkService.getInstance()
                .getJSONApi()
                .getFilms()
                .enqueue(new Callback<FilmShell>() {
            @Override
            public void onResponse(Call<FilmShell> call, Response<FilmShell> response) {
                try {
                    Log.d("MovieMVP", "loaded list film");
                    ArrayList<Film> films = response.body().getFilms();
                    callback.setDownloadedData(films);
                    cashedData(films);
                } catch (Exception e){
                    e.printStackTrace();
                    callback.setErrorDownloaded(R.string.error_get_data);
                }
            }

            @Override
            public void onFailure(Call<FilmShell> call, Throwable t) {
                t.printStackTrace();
                callback.setErrorDownloaded(R.string.error_no_connection);
            }
        });
    }

    private void cashedData(ArrayList<Film> films){
        //TODO realmwork
    }
}
