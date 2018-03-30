package com.pluralsight.javafx.playground;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController implements Initializable {

    @FXML
    private ComboBox comboBox;

    @FXML
    private ComboBox<Country> countryComboBox;

    @FXML
    private ComboBox<Country> imageComboBox;

    @FXML
    private ComboBox<String> priorityComboBox;

    private StringProperty textProp = new SimpleStringProperty();

    ObservableList<Country> countries = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        countries = FXCollections.observableArrayList();
        countries.addAll(new Country("India", "Asia"),
                     new Country("China", "Asia"),
                     new Country("Pakistan", "Asia"),
                     new Country("France", "Europe"),
                     new Country("Germany", "Europe"),
                     new Country("Egypt", "Africa"));

        prepareSimpleCombos();
        prepareImageCombos();

        preparePriorityComboBox();
    }

    private void prepareImageCombos() {
        imageComboBox.setItems(countries);
        imageComboBox.setCellFactory(param -> new CountryCell());
    }

    private void preparePriorityComboBox() {
        priorityComboBox.setItems(FXCollections.observableArrayList("High", "Medium", "Low"));
        priorityComboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {

                ListCell<String> cell = new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(item);
                        if ("high".equalsIgnoreCase(item)) {
                            setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5.0), Insets.EMPTY)));
                        } else if ("medium".equalsIgnoreCase(item)) {
                            setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(5.0), Insets.EMPTY)));
                        } else if ("low".equalsIgnoreCase(item)) {
                            setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(5.0), Insets.EMPTY)));
                        }
                    }
                };
                return cell;
            }
        });
    }

    private void prepareSimpleCombos() {
        comboBox.setItems(FXCollections.observableArrayList("India", new Separator(), "France", "Mexico"));

        countryComboBox.setItems(countries);
        countryComboBox.setOnAction(this::onAction);
        countryComboBox.setEditable(true);

        countryComboBox.setConverter(new StringConverter<Country>() {
            @Override
            public String toString(Country object) {
                if (object == null)
                    return null;

                return object.getName() + ", " + object.getContinent() + " - " + object.getPopulation();
            }

            @Override
            public Country fromString(String string) {
                if (string == null)
                    return null;

                String[] split = string.split("(,)|(-)");
                Country c = new Country(split[0].trim(), split[1].trim());
                log(c);
                return c;
            }
        });
    }

    private void onAction(Event event) {
        log("Selected " + countryComboBox.getValue());
    }

    @FXML
    public void onLogCountryClicked(ActionEvent actionEvent) {
        log(countryComboBox.getSelectionModel().getSelectedItem());
    }
}
