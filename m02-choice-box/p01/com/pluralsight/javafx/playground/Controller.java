package com.pluralsight.javafx.playground;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.setItems(FXCollections.observableArrayList("Asia",
                                                             "Europe",
                                                             "Africa",
                                                             "North America",
                                                             "South America",
                                                             "Australia"));


    }

    @FXML
    public void onAction(ActionEvent actionEvent) {
        log("Selected " + choiceBox.getValue());
    }
}
