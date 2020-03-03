package com.andreyjig.moviemvp.entities;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Objects;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Film extends RealmObject {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("year")
    @Expose
    private int year;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("localized_name")
    @Expose
    private String localizedName;
    @SerializedName("rating")
    @Expose
    private float rating;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("genres")
    @Expose
    private RealmList<String> genres;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ArrayList<String> getGenres() {
        return new ArrayList<>(genres);
    }

    public void setGenres(RealmList<String> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;
        Film film = (Film) o;
        Log.d("Retrofit", "id = " + Boolean.toString(id == film.id) +
                "year = " + Boolean.toString(year == film.year) +
                "rating = " + Boolean.toString(Float.compare(film.rating, rating) == 0) +
                "name = " + Objects.equals(name, film.name) +
                "description = " + Objects.equals(description, film.description) +
                "loc_name = " + Objects.equals(localizedName, film.localizedName) +
                "imageUrl = " + Objects.equals(imageUrl, film.imageUrl) +
                "genres = " + Objects.equals(genres, film.genres));
        return id == film.id &&
                year == film.year &&
                Float.compare(film.rating, rating) == 0 &&
                Objects.equals(name, film.name) &&
                Objects.equals(description, film.description) &&
                Objects.equals(localizedName, film.localizedName) &&
                Objects.equals(imageUrl, film.imageUrl) &&
                Objects.equals(genres, film.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, description, localizedName, rating, imageUrl, genres);
    }
}
