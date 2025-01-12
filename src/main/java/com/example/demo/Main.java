package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;
//    private static Stage secondaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/LogIn.fxml"));
        stage.setTitle("Rental Management System");
        stage.setScene(new Scene(root, 1280, 720));
        stage.setResizable(false);
        stage.show();
    }

//    public void addTenantWindow(String fxml) throws IOException {
//        Parent newWindow = FXMLLoader.load(getClass().getResource(fxml));
//        secondaryStage.setTitle("Tenants");
//        secondaryStage.setScene(new Scene(newWindow, 900, 900));
//        secondaryStage.setResizable(false);
//        secondaryStage.show();
//    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        primaryStage.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}