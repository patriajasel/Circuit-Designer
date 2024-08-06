package com.example.circuitdesigner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomePage extends Application {
    @Override
    public void start(Stage stage) throws IOException {
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
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}