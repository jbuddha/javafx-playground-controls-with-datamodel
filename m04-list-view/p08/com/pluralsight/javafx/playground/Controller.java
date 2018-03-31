package com.pluralsight.javafx.playground;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController implements Initializable {

    @FXML
    public ListView<Book> listView;

    @FXML
    private TextField textField;

    FilteredList<Book> filteredList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Book> items = FXCollections.observableArrayList(
                new Book("Harry Potter", "J.K. Rowling"),
                new Book("Chronicles of Narnia", "C.S. Lewis"),
                new Book("A Song of Ice and Fire", "George R.R. Martin"));

        filteredList = new FilteredList<>(items);

        listView.setItems(filteredList);

        listView.setCellFactory(param -> new ListCell<Book>() {
            @Override
            protected void updateItem(Book item, boolean empty) {
                super.updateItem(item, empty);

                if(empty || item == null) {
                    setText(null);
                } else  {
                    setText(item.getName() + " - " + item.getAuthor());
                }
            }
        });


    }

    @FXML
    void onFilter(ActionEvent event) {
        filteredList.setPredicate(book -> {
            return book.getName().contains(textField.getText()) ||
                   book.getAuthor().contains(textField.getText());
        });
    }

}
