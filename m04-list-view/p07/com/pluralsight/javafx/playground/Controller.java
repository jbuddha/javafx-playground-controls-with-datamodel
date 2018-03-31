package com.pluralsight.javafx.playground;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController implements Initializable {

    @FXML
    public ListView<Book> booksListView;

    public ListView<String> authorListView;

    @FXML
    private TextField textField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Book> items = FXCollections.observableArrayList(
                new Book("Harry Potter", "J.K. Rowling"),
                new Book("Chronicles of Narnia", "C.S. Lewis"),
                new Book("A Song of Ice and Fire", "George R.R. Martin"));

        booksListView.setItems(items);

        booksListView.setCellFactory(param -> new ListCell<Book>() {
            @Override
            protected void updateItem(Book item, boolean empty) {
                super.updateItem(item, empty);

                if(empty || item == null) {
                    setText(null);
                } else  {
                    setText(item.getName());
                    this.backgroundProperty().bind(item.backgroundProperty());
                }
            }
        });

        String[] authors = items.stream()
                                    .map(Book::getAuthor)
                                    .sorted()
                                    .toArray(String[]::new);

        authorListView.setCellFactory(ComboBoxListCell.forListView(authors));
        authorListView.setEditable(true);
        authorListView.setItems(FXCollections.observableArrayList(authors));
    }

    @FXML
    void onAdd(ActionEvent event) {
        if (textField.getText() != null && textField.getText().length() > 0) {
            booksListView.getItems().add(new Book(textField.getText(), ""));
            textField.clear();
        }
    }

    @FXML
    void validate(ActionEvent event) {
        int i = 0;
        for(Book book : booksListView.getItems()) {
            if (book.getAuthor().equalsIgnoreCase(authorListView.getItems().get(i))) {
                book.markRightAnswer();
            } else {
                book.markWrongAnswer();
            }
            i++;
        }
    }

}
