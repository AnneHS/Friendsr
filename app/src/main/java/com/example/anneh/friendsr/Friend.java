package com.example.anneh.friendsr;

import java.io.Serializable;

public class Friend implements Serializable {

    private String name, bio;
    private int drawableId;
    private float rating;

    // constructor
    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }

    // Getters
    public String getName() {

        return name;
    }

    public String getBio() {

        return bio;
    }

    public int getDrawableId() {

        return drawableId;
    }

    public float getRating() {

        return rating;
    }

    // Setter
    public void setRating(float rating) {

        this.rating = rating;
    }
}
