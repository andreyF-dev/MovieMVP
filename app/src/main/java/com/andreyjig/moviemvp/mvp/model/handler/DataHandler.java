package com.andreyjig.moviemvp.mvp.model.handler;


public interface DataHandler<T> {

    void setDownloadedData(T data);
    void setErrorDownloaded(int errorStringId);

}
