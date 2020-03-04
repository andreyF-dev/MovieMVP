package com.andreyjig.moviemvp.entities.holder;

import java.util.Objects;

public class Genre {

    private String name;

    public Genre() {
        this.name = "";
    }

    public Genre(String genre) {
        this.name = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(name, genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
