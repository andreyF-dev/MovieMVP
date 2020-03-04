package com.andreyjig.moviemvp.application;

import android.app.Application;
import io.realm.Realm;

public class MovieMVPApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
