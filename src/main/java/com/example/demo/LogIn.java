package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LogIn {
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Button logInButton;
    @FXML
    private Label wrongLogin;
    @FXML
    private Button visitorButton;

    public LogIn() {

    }

    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    public void visit(ActionEvent visitEvent) throws IOException {
        Main m = new Main();
        m.changeScene("/VisitorAccessPage.fxml");
    }

    private void checkLogin() throws IOException {
        if (email.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogin.setText("Email or Password is empty");
        }
        else if (email.getText().equals("abc") && password.getText().equals("abc")) {
            wrongLogin.setText("Success!");

            Main m = new Main();
            m.changeScene("/VisitorAccessPage.fxml");
        }

        else {
            wrongLogin.setText("Wrong Email or Password");
        }
    }
}
