package com.pluralsight.javafx.playground;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController implements Initializable {

    @FXML
    public ToggleButton toggle;

    @FXML
    private ChoiceBox<Country> choiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.setItems(FXCollections.observableArrayList(new Country("India", "Asia"),
                                                             new Country("China", "Asia"),
                                                             new Country("Pakistan", "Asia"),
                                                             new Country("France", "Europe"),
                                                             new Country("Germany", "Europe"),
                                                             new Country("Egypt", "Africa")));

        choiceBox.setConverter(Country.getStringConverter());
        choiceBox.getSelectionModel().selectFirst();

        Circle circle = new Circle(189, 38, 15);
        circle.fillProperty().bind(getColorBinding());
        add(circle);
    }

    @FXML
    public void onAction(ActionEvent actionEvent) {
        log("Selected " + choiceBox.getValue());
    }

    public ObservableValue<? extends Color> getColorBinding() {
        return new ObjectBinding<Color>() {
            {
                super.bind(choiceBox.showingProperty());
            }
            @Override
            protected Color computeValue() {
                if(choiceBox.isShowing()) {
                    return Color.LIMEGREEN;
                } else {
                    return Color.ORANGERED;
                }
            }
        };
    }
}
