package com.pluralsight.javafx.playground;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController implements Initializable {

    @FXML
    public ListView<Book> listView;

    @FXML
    private TextField textField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Book> items = FXCollections.observableArrayList(
                new Book("Harry Potter", "J.K. Rowling"),
                        new Book("Chronicles of Narnia", "C.S. Lewis"));

        listView.setItems(items);

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            log("Selected: " + newValue);
        });


    }

    @FXML
    void onAdd(ActionEvent event) {
        if (textField.getText() != null && textField.getText().length() > 0) {
            listView.getItems().add(new Book(textField.getText(), ""));
            textField.clear();
        }
    }

}
