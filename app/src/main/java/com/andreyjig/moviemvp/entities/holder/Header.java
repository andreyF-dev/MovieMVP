package com.andreyjig.moviemvp.entities.holder;

public class Header {

    private int titleResId;

    public Header(int titleResId) {
        this.titleResId = titleResId;
    }

    public int getTitleResId() {
        return titleResId;
    }

    public void setTitleResId(int titleResId) {
        this.titleResId = titleResId;
    }
}
