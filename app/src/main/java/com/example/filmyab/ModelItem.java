package com.example.filmyab;

public class ModelItem {
    String nameMovie;
    String Description;
    String picture;

    public ModelItem(String nameMovie, String Description, String picture) {
        this.nameMovie = nameMovie;
        this.Description = Description;
        this.picture = picture;
    }


    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
