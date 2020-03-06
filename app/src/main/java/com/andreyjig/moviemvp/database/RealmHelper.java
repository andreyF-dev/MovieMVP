package com.andreyjig.moviemvp.database;

import com.andreyjig.moviemvp.entities.Film;
import java.util.ArrayList;
import io.realm.Realm;
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

    public void cacheFilms(ArrayList<Film> films){
        realm.executeTransactionAsync(realm -> realm.copyToRealmOrUpdate(films));
    }

    public ArrayList<Film> getAllFilms(){
        RealmResults<Film> films = realm.where(Film.class).findAll();
        return new ArrayList<>(films);
    }

    public Film getFilmById(int id){
        return realm.where(Film.class).equalTo("id", id).findFirst();
    }
}
