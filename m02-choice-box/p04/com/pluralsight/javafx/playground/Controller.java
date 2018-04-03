package com.pluralsight.javafx.playground;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleButton;

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
    }

    @FXML
    public void onAction(ActionEvent actionEvent) {
        log("Selected " + choiceBox.getValue());
    }

}
