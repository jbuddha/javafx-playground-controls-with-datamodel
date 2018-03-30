package com.pluralsight.javafx.playground;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController implements Initializable {

    @FXML
    private ComboBox comboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.setItems(FXCollections.observableArrayList("India", new Separator(), "France", "Mexico"));
    }

}
