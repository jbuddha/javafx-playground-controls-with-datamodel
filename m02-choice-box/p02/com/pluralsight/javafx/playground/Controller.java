package com.pluralsight.javafx.playground;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
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

        choiceBox.setOnShowing(this::onShowing);
        choiceBox.setOnHiding(this::onHiding);


    }

    private void onHiding(Event event) {
        log("About to hide");
    }

    private void onShowing(Event event) {
        log("About to show");
    }



    @FXML
    public void onAction(ActionEvent actionEvent) {
        log("Selected " + choiceBox.getValue());
    }
}
