package com.pluralsight.javafx.playground;

import javafx.util.StringConverter;

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

    public static StringConverter<Country> getStringConverter() {
        return new StringConverter<Country>() {
            @Override
            public String toString(Country country) {
                return country.name + ", " + country.continent;
            }

            @Override
            public Country fromString(String string) {
                return null;
            }
        };
    }

    @Override
    public String toString() {
        return name + ", " + continent + " - Population: " + population;
    }
}
