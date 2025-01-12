package com.example.demo.controller;

import com.example.demo.Main;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ProfileController {

    public void submit(ActionEvent event) throws IOException {
        Main m = new Main();
        //Get user to see where to go back
        m.changeScene("/Host.fxml");
    }
}
