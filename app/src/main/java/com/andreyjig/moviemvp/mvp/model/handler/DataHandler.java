package com.andreyjig.moviemvp.mvp.model.handler;

public interface DataHandler<T> {

    void readyData(T data);
    void callError(int errorStringId);
}
