package com.example.circuitdesigner;

import javafx.stage.Stage;

public class StageService {

    private Stage primaryStage;
    private Stage secondaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setSecondaryStage(Stage secondaryStage) {
        this.secondaryStage = secondaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage; // Added method to get primary stage
    }

    public void closeBothStages() {
        if(primaryStage != null) {
            primaryStage.close();
        }

        if(secondaryStage != null) {
            secondaryStage.close();
        }
    }
}
