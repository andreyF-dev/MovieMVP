package com.andreyjig.moviemvp.database;

import android.util.Log;

import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.mvp.model.handler.DataHandler;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class RealmHelper{

    private static RealmHelper instance;
    private Realm realm;

    public static RealmHelper getInstance(){
        if (instance == null){
            instance = new RealmHelper();
        }
        return instance;
    }
    private RealmHelper (){
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("films.db")
                .schemaVersion(1)
                .build();

        realm = Realm.getInstance(configuration);
    }

    public void cashedFilms(ArrayList<Film> films, DataHandler<Film> dataHandler){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (Film film: films){
                    Film cashedFilm = realm.where(Film.class).equalTo("id", film.getId()).findFirst();
                    if (cashedFilm == null || !film.equals(cashedFilm)){
                        realm.copyToRealmOrUpdate(film);
                        dataHandler.setChange(film);
                    }
                }
            }
        });
    }

    public ArrayList<Film> getAllFilms(){
        RealmResults<Film> films = realm.where(Film.class).findAll();
        films.addChangeListener(new RealmChangeListener<RealmResults<Film>>() {
            @Override
            public void onChange(RealmResults<Film> films) {

            }
        });
        return new ArrayList<Film>(realm.copyFromRealm(films));
    }

    public Film getFilmById(int id){
        Film film = realm.where(Film.class).equalTo("id", id).findFirst();
        return film;
    }
}
