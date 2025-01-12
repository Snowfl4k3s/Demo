package com.example.demo.controller;

import com.example.demo.MyListener;
import com.example.demo.models.Property;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class PropertiesController {
    @FXML
    private Label addressID;

    @FXML
    private Label priceNumber;

    @FXML
    private void click(MouseEvent actionEvent) {
        myListener.onClickListener(property);
    }

    private Property property;

    private MyListener myListener;

    public void setData(Property property, MyListener myListener) {
        this.property = property;
        this.myListener = myListener;
        addressID.setText(property.getAddress());
        priceNumber.setText("" + property.getPricing());
    }
}
