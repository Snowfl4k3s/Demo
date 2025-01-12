package com.example.demo;

import javafx.event.ActionEvent;

import java.io.IOException;

public class Profile {

    public void submit(ActionEvent event) throws IOException {
        Main m = new Main();
        //Get user to see where to go back
        m.changeScene("/Host.fxml");
    }
}
