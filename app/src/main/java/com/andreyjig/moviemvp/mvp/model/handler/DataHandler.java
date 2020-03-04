package com.andreyjig.moviemvp.mvp.model.handler;

public interface DataHandler<T> {

    void setData(T data);
    void setError(int errorStringId);
}
