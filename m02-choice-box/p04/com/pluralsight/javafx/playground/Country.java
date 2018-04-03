package com.pluralsight.javafx.playground;

import java.util.Random;

public class Country {
    private String name;
    private String continent;
    private int population;

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
        population = new Random().nextInt(1234567890);
    }

    @Override
    public String toString() {
        return name + ", " + continent + " - Population: " + population;
    }
}
