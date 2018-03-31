package com.pluralsight.javafx.playground;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {
    private StringProperty  name;
    private StringProperty  author;
    private IntegerProperty year;

    public Book(String name, String author, Integer year) {
        this.name = new SimpleStringProperty(name);
        this.author = new SimpleStringProperty(author);
        this.year = new SimpleIntegerProperty(year);
    }

    public String getName() {
        return name.get();
    }

    public String getAuthor() {
        return author.get();
    }

    public Integer getYear() {
        return year.get();
    }

    public StringProperty authorProperty() {
        return author;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public void setYear(int year) {
        this.year.set(year);
    }
}
