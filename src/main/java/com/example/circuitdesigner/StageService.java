package com.example.circuitdesigner;

import javafx.stage.Stage;

public class StageService {


    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage; // Added method to get primary stage
    }

    

}
