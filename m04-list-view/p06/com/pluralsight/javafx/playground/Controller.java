package com.pluralsight.javafx.playground;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController implements Initializable {

    @FXML
    public ListView<Book> booksListView;

    @FXML
    private TextField textField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Book> items = FXCollections.observableArrayList(
                new Book("Harry Potter", "J.K. Rowling"),
                        new Book("Chronicles of Narnia", "C.S. Lewis"),
                new Book("A Song of Ice and Fire", "George R.R. Martin"));

        booksListView.setItems(items);

//        booksListView.setCellFactory(param -> new ListCell<Book>() {
//            @Override
//            protected void updateItem(Book item, boolean empty) {
//                super.updateItem(item, empty);
//
//                if(empty || item == null) {
//                    setText(null);
//                } else  {
//                    setText(item.getName());
//                }
//            }
//        });

        booksListView.setCellFactory(TextFieldListCell.forListView(new StringConverter<Book>() {
            @Override
            public String toString(Book object) {
                return object.getName() + (object.getAuthor()!=null ? ", " + object.getAuthor(): "");
            }

            @Override
            public Book fromString(String string) {
                if (string == null)
                    return null;

                if (string.contains(",")) {
                    String[] split = string.split(",");
                    return new Book(split[0].trim(), split[1].trim());
                } else {
                    return new Book(string, null);
                }
            }
        }));
        booksListView.setEditable(true);
    }


}
