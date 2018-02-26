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
    private ChoiceBox<String> choiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.setItems(FXCollections.observableArrayList("Asia",
                                                             "Europe",
                                                             "Africa",
                                                             "North America",
                                                             "South America",
                                                             "Australia"));

        choiceBox.visibleProperty().bind(toggle.selectedProperty().not());

        choiceBox.setOnAction(this::newOnAction);
    }

    private void newOnAction(ActionEvent actionEvent) {
        log("New action performed");
    }

    @FXML
    public void onAction(ActionEvent actionEvent) {
        log("Selected " + choiceBox.getValue());
    }

    @FXML
    public void addItem(ActionEvent actionEvent) {
        choiceBox.getItems().add("Item " + System.currentTimeMillis() % 1000);
        choiceBox.show();
    }
}
