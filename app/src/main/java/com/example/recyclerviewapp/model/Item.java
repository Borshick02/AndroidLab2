package com.example.recyclerviewapp.model;

public class Item {
    private String title;
    private String description;
    private int imageResource;

    // Конструктор
    public Item(String title, String description, int imageResource) {
        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
    }

    // Геттеры
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }
}
