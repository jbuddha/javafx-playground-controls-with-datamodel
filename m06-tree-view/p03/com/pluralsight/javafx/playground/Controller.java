package com.pluralsight.javafx.playground;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    private TreeView<String> tree;

    ObservableList<String> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeItem<String> continent = new TreeItem<>();

        TreeItem<String> asiaItem = new TreeItem<>("Asia");
        TreeItem<String> africaItem = new TreeItem<>("Africa");

        init(continent, asiaItem, africaItem);

        tree.setEditable(true);
        tree.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
            @Override
            public TreeCell<String> call(TreeView<String> param) {

                return new CheckBoxTreeCell<String>(){
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if(empty) {
                            setGraphic(null);
                            setText(null);
                        } else if(!getTreeItem().isLeaf()){
                            setGraphic(null);
                            // show it after checkbox is gone for parent
                            getTreeItem().setExpanded(true);
                        }
                    }
                };
            }
        });
    }

    private void init(TreeItem<String> continent, TreeItem<String> asiaItem, TreeItem<String> africaItem) {
        tree.setRoot(continent);
        tree.setShowRoot(false);

        continent.getChildren().add(asiaItem);
        continent.getChildren().add(africaItem);

        asiaItem.setExpanded(true);
        africaItem.setExpanded(true);

        TreeItem<String> indiaItem = new TreeItem<>("India");
        TreeItem<String> chinaItem = new TreeItem<>("China");

        asiaItem.getChildren().addAll(indiaItem, chinaItem);

        TreeItem<String> kenyaItem = new TreeItem<>("Kenya");
        TreeItem<String> egyptItem = new TreeItem<>("Egypt");

        africaItem.getChildren().addAll(kenyaItem,egyptItem);

        Image asiaImage = new Image(getClass().getResourceAsStream("Asia.png"));
        Image africaImage = new Image(getClass().getResourceAsStream("Africa.png"));

        ImageView asiaImageView = new ImageView(asiaImage);
        ImageView africaImageView = new ImageView(africaImage);

        asiaImageView.setFitWidth(24);
        asiaImageView.setFitHeight(27);

        africaImageView.setFitWidth(24);
        africaImageView.setFitHeight(27);

        asiaItem.setGraphic(asiaImageView);
        africaItem.setGraphic(africaImageView);

        tree.getSelectionModel()
            .selectedItemProperty()
            .addListener((observable, oldValue, newValue) -> log("New value selected is " + newValue.getValue()));
    }

}

