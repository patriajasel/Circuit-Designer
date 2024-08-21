package com.example.circuitdesigner;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;

import javax.swing.event.ChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class SketchBoard implements Initializable {

    /* N O T E S

    * buttons designs
    * menu button designs

    */

    /* F I L E   M E N U */

    // For SketchBoard Size

    private final List<String> filePaths = new ArrayList<>();
    private final List<String> fileNames = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final String compFolderPath = "src/main/resources/Component-Libraries";
        File folder = new File(compFolderPath);

        scanFolder(folder, filePaths, fileNames);

        parsingJSONCompFiles(filePaths);

        compsMenu.setMinWidth(130);
        compsMenu.setMaxWidth(130);

    }

    public static void scanFolder(File folder, List<String> filePaths, List<String> fileNames) {
        if(folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for(File file: files) {
                    if(file.isDirectory()) {
                        scanFolder(file, filePaths, fileNames);
                    } else {
                        filePaths.add(file.getPath());
                        fileNames.add(file.getName());
                    }
                }
            }
        }
    }

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



    public void parsingJSONCompFiles(List<String> filePaths) {
        ObjectMapper objectMapper = new ObjectMapper();
        Package pkg;

        MenuItem allComps = new MenuItem("All Components");
        compsMenu.getItems().add(allComps);
        allComps.setOnAction(event -> {
            compsMenu.setText(allComps.getText());
            compsContainer.getChildren().clear();
            compsMenu.getItems().clear();
            parsingJSONCompFiles(filePaths);
        });

        try {
            for(int i = 0; i < filePaths.size(); i++) {
                pkg = objectMapper.readValue(new File(filePaths.get(i)), Package.class);
                populateGridPaneComps(pkg);
                populateCompMenu(pkg.packageType, pkg);
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @FXML
    private VBox compsContainer;

    public void populateGridPaneComps(Package pkg) {

        GridPane components = new GridPane();

        Label compType = new Label(pkg.packageType);
        compType.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 16));
        compType.setPadding(new Insets(10,10,10,10));

        Separator compSeparator = new Separator();
        compSeparator.setMinHeight(4);
        compSeparator.setPadding(new Insets(0,5,0,5));

        compsContainer.getChildren().addAll(
                compType,
                compSeparator,
                components
        );

        components.setPrefSize(230, 575);
        components.setHgap(10);
        components.setVgap(10);
        components.setPadding(new Insets(10,10,10,10));

        int numColumns = 2;

        for (int index = 0; index < pkg.components.size(); index++) {
            int i = index % numColumns;
            int j = index / numColumns;

            Button compButton = new Button();
            compButton.setMinWidth(100);
            compButton.setMinHeight(100);
            compButton.setMaxWidth(100);
            compButton.setMaxHeight(100);
            compButton.setText(pkg.components.get(index).name);
            components.add(compButton,i,j);

        }

    }

    @FXML
    MenuButton compsMenu;
    public void populateCompMenu(String packageType, Package pkg){
        MenuItem pkgType = new MenuItem();
        pkgType.setText(packageType);

        pkgType.setOnAction(event -> {
            compsMenu.setText(packageType);
            compsContainer.getChildren().clear();
            populateGridPaneComps(pkg);
        });

        compsMenu.getItems().add(pkgType);

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
