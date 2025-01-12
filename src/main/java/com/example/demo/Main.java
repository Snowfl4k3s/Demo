package com.example.demo;

import com.example.demo.models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.demo.Loaders.*;

import java.io.IOException;
import java.util.List;


public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/LogIn.fxml"));
        stage.setTitle("Rental Management System");
        stage.setScene(new Scene(root, 1280, 720));
        stage.setResizable(false);
        stage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        primaryStage.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        List<Tenant> TenantsList = DataLoader.loadTenants();

        for (Tenant Tenant : TenantsList) {
            System.out.println(Tenant);
        }

        List<Property> PropertyList = DataLoader.loadProperties();
        for (Property Property : PropertyList) {
            System.out.println(Property);
        }
        //launch();
    }
}