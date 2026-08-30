package com.example.playzone.model;

// Model class that stores game information such as title, category, price, description, and image.

import java.io.Serializable;

public class Game implements Serializable {

    private String title;
    private String category;
    private double price;
    private String description;
    private int imageResId;

    public Game(String title, String category, double price, String description, int imageResId) {

        this.title = title;
        this.category = category;
        this.price = price;
        this.description = description;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
