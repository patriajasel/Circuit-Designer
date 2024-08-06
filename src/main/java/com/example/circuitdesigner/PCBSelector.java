package com.example.circuitdesigner;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class PCBSelector implements Initializable {

    /* F O R   C H O I C E   B O X E S */

    @FXML
    private ChoiceBox<String> sizesChoiceBox;

    private final String[] sizes = {
            "2 x 2 inches (51 x 51 mm)",
            "2 x 4 inches (51 x 102 mm)",
            "2 x 5 inches (51 x 127 mm)",
            "2 x 6 inches (51 x 152 mm)",
            "4 x 2 inches (102 x 51 mm)",
            "4 x 4 inches (102 x 102 mm)",
            "4 x 5 inches (102 x 127 mm)",
            "4 x 6 inches (102 x 152 mm)",
            "5 x 2 inches (127 x 51 mm)",
            "5 x 4 inches (127 x 102 mm)",
            "5 x 5 inches (127 x 127 mm)",
            "5 x 6 inches (127 x 152 mm)",
            "6 x 2 inches (152 x 51 mm)",
            "6 x 4 inches (152 x 102 mm)",
            "6 x 5 inches (152 x 127 mm)",
            "6 x 6 inches (152 x 152 mm)",
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        sizesChoiceBox.getItems().addAll(sizes);
        sizesChoiceBox.setValue(sizes[0]);

    }
}
