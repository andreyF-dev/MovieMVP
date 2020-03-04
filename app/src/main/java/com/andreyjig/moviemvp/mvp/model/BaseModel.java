package com.andreyjig.moviemvp.mvp.model;

import com.andreyjig.moviemvp.mvp.model.handler.DataHandler;

public abstract class BaseModel<D> {

    public DataHandler<D> callback;

    public BaseModel(DataHandler<D> callback) {
        this.callback = callback;
    }
    
    public abstract void getData();
}
