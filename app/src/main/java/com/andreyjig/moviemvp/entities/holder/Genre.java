package com.andreyjig.moviemvp.entities.holder;

import java.util.Objects;

public class Genre {

    private String name;
    private boolean isSelected;

    public Genre(String genre) {
        this.name = genre;
        isSelected = false;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelectedTrue(){
        isSelected = true;
    }

    public void setSelectedFalse(){
        isSelected = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return isSelected == genre.isSelected &&
                Objects.equals(name, genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isSelected);
    }
}
