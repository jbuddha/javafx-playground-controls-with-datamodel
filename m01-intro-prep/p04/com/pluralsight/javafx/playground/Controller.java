package com.pluralsight.javafx.playground;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController implements Initializable {



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Button b = new Button("Dynamic Button");
        TextField t = new TextField("Dynamic Text field");
        t.setLayoutY(50);
        add(b, t);
    }

}
