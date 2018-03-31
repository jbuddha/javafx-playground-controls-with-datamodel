package com.pluralsight.javafx.playground;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController implements Initializable {

    @FXML
    private TableView<Book> table;

    @FXML
    private TableColumn<Book, String> nameColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, Integer> publishedColumn;

    @FXML
    private Button duplicateButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Book> items = FXCollections.observableArrayList(
                new Book("Harry Potter", "J.K. Rowling", 1998),
                new Book("Chronicles of Narnia", "C.S. Lewis", 1950),
                new Book("A Song of Ice and Fire", "George R.R. Martin", 1996));

        table.setItems(items);

        nameColumn.setCellValueFactory(item -> item.getValue().nameProperty());
        authorColumn.setCellValueFactory(item -> item.getValue().authorProperty());
        publishedColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("Year"));

        duplicateButton.disableProperty().bind(table.getSelectionModel().selectedIndexProperty().isEqualTo(-1));

        table.setEditable(true);
        publishedColumn.setEditable(false);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        authorColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        authorColumn.setOnEditCommit(event -> {
            String newValue = event.getNewValue();
            if(event.getNewValue().contains(",")) {
                newValue = newValue.replace(",", "");
            }
            event.getRowValue().setAuthor(newValue);
        });
        
    }

    @FXML
    void onAdd(ActionEvent event) {
        table.getItems().add(new Book("A Court of Thorn and Roses", "Sarah J. Mass", 2015));
    }

    @FXML
    void onDuplicate(ActionEvent event) {
        table.getItems().add(table.getSelectionModel().getSelectedItem());
    }

}
