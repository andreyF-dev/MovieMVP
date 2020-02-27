package com.andreyjig.moviemvp.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import io.realm.RealmList;
import io.realm.annotations.PrimaryKey;

public class Film {

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
    private double rating;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
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
}
