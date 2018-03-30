package com.pluralsight.javafx.playground;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController implements Initializable {

    @FXML
    private ComboBox comboBox;

    @FXML
    private ComboBox countryComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.setItems(FXCollections.observableArrayList("India", new Separator(), "France", "Mexico"));

        ObservableList<Object> counties = FXCollections.observableArrayList();
        counties.addAll(new Country("India", "Asia"),
                     new Country("China", "Asia"),
                     new Country("Pakistan", "Asia"),
                     new Separator(),
                     new Country("France", "Europe"),
                     new Country("Germany", "Europe"),
                     new Separator(),
                     new Country("Egypt", "Africa"));

        countryComboBox.setItems(counties);
        countryComboBox.setOnAction(this::onAction);
        countryComboBox.setEditable(true);



    }

    private void onAction(Event event) {
        log("Selected " + countryComboBox.getValue());
    }
}
