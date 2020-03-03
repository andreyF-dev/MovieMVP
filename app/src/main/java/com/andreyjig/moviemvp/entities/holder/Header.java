package com.andreyjig.moviemvp.entities.holder;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Header)) return false;
        Header header = (Header) o;
        return titleResId == header.titleResId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleResId);
    }
}
