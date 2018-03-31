package com.pluralsight.javafx.playground;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Paint;

public class Book {
    private String name;
    private String author;

    private Property<Background> backgroundProperty = new SimpleObjectProperty<>();

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        markRightAnswer();
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void markWrongAnswer() {
        backgroundProperty.setValue(new Background(new BackgroundFill(Paint.valueOf("#FF0000"), null, null)));
    }

    public void markRightAnswer() {
        backgroundProperty.setValue(new Background(new BackgroundFill(Paint.valueOf("#00FF00"), null, null)));
    }
    public Property<Background> backgroundProperty() {
        return backgroundProperty;
    }

    @Override
    public String toString() {
        return "Book{" + "name='" + name + '\'' + ", author='" + author + '\'' + '}';
    }
}
