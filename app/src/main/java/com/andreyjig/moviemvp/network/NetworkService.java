package com.andreyjig.moviemvp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static NetworkService instance;
    private static final String url = "https://s3-eu-west-1.amazonaws.com";
    private Retrofit retrofit;

    private NetworkService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        if (instance == null) {
            instance = new NetworkService();
        }
        return instance;
    }

    public MovieJSON getJSONApi() {
        return retrofit.create(MovieJSON.class);
    }
}
