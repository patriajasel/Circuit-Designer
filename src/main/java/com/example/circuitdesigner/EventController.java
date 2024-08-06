package com.example.circuitdesigner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class EventController{

    /* F O R   B U T T O N   E F F E C T S */

    // Homepage Descriptions for user options
    private final String[] descriptions = {
        "PCB Sketch is a free to use software for PCB footprint designing, PCB engraving and PCB drilling.",
            "Create your own PCB design using our own library of components.",
            "Upload, View and Edit your existing PCB design with our editor.",
            "Control your CNC Machine for prototyping your PCB design to your Copper Board."
    };

    @FXML
    private Label descriptLabel; // description label ID

    // When user hovers on the Button in the Homepage
    public void onButtonHover(MouseEvent e) {

        Object source = e.getSource();

        if(source instanceof Button button){
            String fxId = button.getId(); // getting the button ID

            // Label value is based on the button that was hovered
            if(Objects.equals(fxId, "createButton")){
                descriptLabel.setText(descriptions[1]);
            }
            else if(Objects.equals(fxId, "importButton")){
                descriptLabel.setText(descriptions[2]);
            }
            else if(Objects.equals(fxId, "controlButton")){
                descriptLabel.setText(descriptions[3]);
            }
        }
    }

    public void onButtonHoverExit(MouseEvent e) {
        descriptLabel.setText(descriptions[0]); // default Label value after button was hovered
    }


    /* S C E N E   S W I T C H I N G   M E T H O D S */

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToPCBSize(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PCBSelector.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
