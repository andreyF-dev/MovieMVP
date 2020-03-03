package com.andreyjig.moviemvp.mvp.model.handler;

import java.util.ArrayList;

public interface DataHandler<T> {

    void setData(ArrayList<T> data);
    void setErrorDownloaded(int errorStringId);
}
