package com.andreyjig.moviemvp.mvp.presenter;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.mvp.model.BaseModel;
import com.andreyjig.moviemvp.mvp.model.handler.DataHandler;
import com.andreyjig.moviemvp.mvp.model.handler.ErrorHandler;
import com.andreyjig.moviemvp.mvp.view.BaseView;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

public abstract class BasePresenter<T extends BaseView, D> extends MvpPresenter<T>
        implements DataHandler<D>, ErrorHandler {

    public BaseModel<D> model;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showPreviewScreen();
        getViewState().updateTitle(getTitleId());
        setModel();
        model.getData();
    }

    @Override
    public void setData(D data) {
        boolean isNull = data == null;
        boolean isList = data instanceof List;
        if (!isNull && (!isList || (isList && ((List)data).size() > 0))){
            hideErrorDialog();
            setCorrectContent(data);
        } else {
            setError(R.string.error_get_data);
        }
    }

    @Override
    public void setError(int errorStringId) {
        getViewState().showError(errorStringId, this);
    }

    @Override
    public void hideErrorDialog() {
        getViewState().hideError();
    }

    @Override
    public void retryAction() {
        model.getData();
    }

    private void setCorrectContent(D data){
        getViewState().hidePreviewScreen();
        setContent(data);
    }
    public abstract void setModel();

    public abstract void setContent(D data);

    public abstract int getTitleId();
}
