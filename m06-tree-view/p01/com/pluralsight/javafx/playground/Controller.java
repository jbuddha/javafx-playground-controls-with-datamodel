package com.pluralsight.javafx.playground;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController implements Initializable {

    @FXML
    private TreeView<String> tree;

    ObservableList<String> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeItem<String> continent = new TreeItem<>("A cool tree");

        TreeItem<String> asiaItem = new TreeItem<>("Asia");
        TreeItem<String> africaItem = new TreeItem<>("Africa");

        tree.setRoot(continent);
        //tree.setShowRoot(false);
        //asiaItem.setExpanded(true);

        continent.getChildren().add(asiaItem);
        continent.getChildren().add(africaItem);

        TreeItem<String> indiaItem = new TreeItem<>("India");
        TreeItem<String> chinaItem = new TreeItem<>("China");

        asiaItem.getChildren().addAll(indiaItem, chinaItem);

        TreeItem<String> kenyaItem = new TreeItem<>("Kenya");
        TreeItem<String> egyptItem = new TreeItem<>("Egypt");

        africaItem.getChildren().addAll(kenyaItem,egyptItem);
    }

}
