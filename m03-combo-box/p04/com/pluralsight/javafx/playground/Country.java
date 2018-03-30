package com.pluralsight.javafx.playground;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Country {
    private String name;
    private String continent;
    private int population;

    private ImageView imageView;

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
        this.population = new Random().nextInt(100);
        String fileName = continent.toLowerCase().trim().replace(' ', '-') + ".png";
        Image image = new Image(getClass().getResourceAsStream(fileName));
        imageView = new ImageView(image);
        imageView.setFitHeight(25);
        imageView.setFitWidth(25);
    }

    @Override
    public String toString() {
        return name + ", " + continent + " - Population: " + population;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public int getPopulation() {
        return population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
