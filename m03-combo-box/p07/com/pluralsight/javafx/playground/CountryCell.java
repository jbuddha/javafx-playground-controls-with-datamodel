package com.pluralsight.javafx.playground;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class CountryCell extends ListCell<Country> {

    @Override
    protected void updateItem(Country item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty)
            setGraphic(null);
        else {
            Image image = new Image(getClass().getResourceAsStream(item.getContinent() + ".png"));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(25);
            imageView.setFitWidth(25);
            setGraphic(new HBox(imageView, new Label(item.getName())));
        }

        setText("");
    }
}

