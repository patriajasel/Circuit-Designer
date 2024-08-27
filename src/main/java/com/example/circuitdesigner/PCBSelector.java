package com.example.circuitdesigner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.foreign.SymbolLookup;
import java.net.URL;
import java.util.*;

public class PCBSelector implements Initializable {

    @FXML
    private TextField projectName;

    /* F O R   C H O I C E   B O X E S */

    @FXML
    private ChoiceBox<String> sizesChoiceBox;

    private final int[] PcbHeight = {2, 2, 2, 3, 3, 4, 4};
    private final int[] PcbWidth = {2, 3, 4, 3, 4, 4, 6};

    private final List<String> PcbSizes = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        for (int i = 0; i < PcbWidth.length; i++) {
            String size = PcbHeight[i] + " x " + PcbWidth[i] + " inches";
            PcbSizes.add(size);
        }

        // Declaring the list in the choice box
        sizesChoiceBox.getItems().addAll(PcbSizes);
        sizesChoiceBox.setValue(PcbSizes.getFirst()); // Setting size[0] as the first value of the choice box

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

        //Closing the first window
        stageService.getPrimaryStage().close();

        // Loading the new window
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("SketchBoard.fxml")));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Sending the index of the choice box value
        SketchBoard sketchBoardWindow = loader.getController();
        setCanvasSize(PcbSizes.indexOf(sizesChoiceBox.getValue()), sketchBoardWindow);

        //sketchBoardWindow.populateComponents();

        // Setting the scene for the new window
        stage.setScene(new Scene(root));
        stage.setResizable(true);
        stage.setMaximized(true); // Maximizing Window on start
        stage.setTitle(projectName.getText());
        stage.show();

    }

    // Removing PCB window but retaining the Homepage Window
    public void cancelCurrentWindow (ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PCBSelector.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.close();
    }

    public void setCanvasSize(int index, SketchBoard sketchBoardWindow) {

        // Setting the sketch board size based on the user's choice
        sketchBoardWindow.setSketchHeight(PcbHeight[index]);
        sketchBoardWindow.setSketchWidth(PcbWidth[index]);
        sketchBoardWindow.setAnchorSize();
    }

}
