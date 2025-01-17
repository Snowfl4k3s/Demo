package com.example.demo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPropertyController implements Initializable {
    @FXML
    private ChoiceBox<String> choiceBox;

    private String[] choice = {"Residential", "Commercial"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(choice);
    }

    public void submit(ActionEvent event) throws IOException {
        System.out.println("a");
    }
}
