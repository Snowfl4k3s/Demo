package com.example.demo;

import com.example.demo.models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.demo.Loaders.*;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
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
        int userId = 1; // Example User ID
        String Name = "John Doe";
        String dob = "1990-05-15"; // Date of Birth in YYYY-MM-DD format
        String email = "johndoe@example.com";
        String password = "newpassword123"; // It is advised to hash the password before saving

        // Update user data
        ProfileEditor.updateUser(userId, Name, dob, email, password);
    }
}