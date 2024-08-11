package com.example.circuitdesigner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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

        // Declaring the list in the choice box
        sizesChoiceBox.getItems().addAll(sizes);
        sizesChoiceBox.setValue(sizes[0]); // Setting size[0] as the first value of the choice box

    }

    private Stage stage;
    private Parent root;
    private StageService stageService;

    // Setter for setting stage service
    public void setStageService(StageService stageService) {
        this.stageService = stageService;
    }

    // Switching to SketchBoard window and closing the Homepage Window
    public void switchToSketchBoard(ActionEvent event) throws IOException {

        stageService.getPrimaryStage().close();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SketchBoard.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setMaximized(true); // Maximizing Window on start
        stage.show();

    }

    // Removing PCB window but retaining the Homepage Window
    public void cancelCurrentWindow (ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PCBSelector.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.close();
    }

}
