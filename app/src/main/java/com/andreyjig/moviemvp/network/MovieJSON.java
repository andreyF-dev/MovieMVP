package com.andreyjig.moviemvp.network;

import com.andreyjig.moviemvp.entities.shell.FilmShell;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieJSON {
    @GET("/sequeniatesttask/films.json")
    public Call<FilmShell> getFilms();
}
