package com.andreyjig.moviemvp.mvp.model.handler;

public interface DataHandler<T> {

    void setData(T data);
    void callError(int errorStringId);
}
