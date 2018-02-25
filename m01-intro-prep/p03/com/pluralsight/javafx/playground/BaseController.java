package com.pluralsight.javafx.playground;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class BaseController {

    @FXML
    private TextArea log;

    protected void log(Object line) {
        log.appendText(line.toString() + System.lineSeparator());
    }

}
