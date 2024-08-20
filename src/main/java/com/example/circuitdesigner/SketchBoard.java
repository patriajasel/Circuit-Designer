package com.example.circuitdesigner;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;

import java.util.List;


public class SketchBoard {

    /* N O T E S

    * buttons designs
    * menu button designs
    * make a ruler for the sketch board in vertical and horizontal

    */

    /* F I L E   M E N U */

    // For SketchBoard Size

    @FXML
    AnchorPane sketchboard;

    public void setAnchorSize(double prefWidth, double prefHeight ) {

        Screen primaryScreen = Screen.getPrimary();

        Rectangle2D bounds = primaryScreen.getVisualBounds();

        double screenWidth = bounds.getWidth();
        double screenHeight = bounds.getHeight();
        double dpi = Screen.getPrimary().getDpi();

        double anchorPaneWidth = prefWidth * dpi;
        double anchorPaneHeight = prefHeight * dpi;

        sketchboard.setPrefWidth(anchorPaneWidth);
        sketchboard.setPrefHeight(anchorPaneHeight);

    }

    @FXML
    private GridPane compsContainer;

    public void populateComponents(List<Package> packageList) {

        for(int i = 0; i < packageList.size(); i++){
            compsContainer.add(packageList.get(i), 0, 1);
        }
    }

    // For creating new project
    public void newProject() {}

    // For opening a project
    public void openProject() {}

    // For saving a project
    public void saveProject() {}

    // For saving new project as something...
    public void saveProjectAs() {}

    // For importing a project
    public void importProject() {}

    // For exporting a project
    public void exportProject() {}

    // For exiting the App
    public void exitApp() {}


    /* EDIT  M E N U */

    // Undoing an action
    public void undoAction() {}

    // Redoing an action
    public void redoAction() {}

    // Start tracing
    public void startTracing() {}


    /* S E T T I N G S   M E N U */

    // Opening Configuration window
    public void openConfiguration() {}


    /* A B O U T   U S   M E N U */

    // Opening about us window
    public void aboutUs() {}

    /* S I D E   B U T T O N S */

    public void home() {}

    public void rotate() {}

    public void expand() {}

    public void delete() {}

    public void trace() {}

    public void outline() {}

}
