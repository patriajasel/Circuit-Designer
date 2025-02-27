package com.example.circuitdesigner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

/*  N O T E S

    * Optimize the loaders into just one method

 */

public class HomePage extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HomePage.class.getResource("Homepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Inheriting CSS file
        String cssPath = Objects.requireNonNull(this.getClass().getResource("/css/Application.css")).toExternalForm();
        scene.getStylesheets().add(cssPath);

        // Title and Icon of the Application
        String resourcePath = Objects.requireNonNull(getClass().getResource("/assets/logo/logo.png")).toString();
        Image icon = new Image(resourcePath);
        stage.getIcons().add(icon);
        stage.setTitle("Circuit Designer");

        //Setting the Scene and showing the Stage
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        // Creating instance of the EventController class
        EventController eventController = fxmlLoader.getController();

        // Passing Homepage stage as primary stage and stage service to Stage service constructor
        StageService stageService = new StageService();
        eventController.setPrimaryStage(stage);
        eventController.setStageService(stageService);

        /*LBRSTAXParser parser = new LBRSTAXParser();
        parser.parseLBRData("src/main/resources/assets/footprints/User-Submitted.lbr", "src/main/resources/Component-Libraries/User-Submitted.json");*/

    }

    public static void main(String[] args) {
        launch();
    }
}