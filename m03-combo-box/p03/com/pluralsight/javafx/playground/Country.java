package com.pluralsight.javafx.playground;

import java.util.Random;

public class Country {
    private String name;
    private String continent;
    private int population;

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
        this.population = new Random().nextInt(100);
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
}
