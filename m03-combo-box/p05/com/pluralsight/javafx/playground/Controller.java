package com.pluralsight.javafx.playground;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController implements Initializable {

    @FXML
    private ComboBox comboBox;

    @FXML
    private ComboBox<Country> countryComboBox;

    @FXML
    private ComboBox<HBox> imageComboBox;

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


    }

    private void prepareImageCombos() {
        for(Country country: countries) {
            imageComboBox.getItems()
                         .add(new HBox(country.getImageView(), new Label(country.getName())));
        }
        ListCell<HBox> buttonCell = new ListCell<>();
        imageComboBox.setButtonCell(buttonCell);
        buttonCell.textProperty().bindBidirectional(textProp);
        imageComboBox.setOnAction(event -> {
            Label node = (Label)imageComboBox.getSelectionModel()
                                     .getSelectedItem()
                                     .getChildren()
                                     .get(1);
            textProp.setValue(node.getText());
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
