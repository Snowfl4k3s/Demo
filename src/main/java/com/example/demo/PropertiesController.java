package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PropertiesController {
    @FXML
    private Label addressID;

    @FXML
    private Label priceNumber;

    private Property property;

    public void setData(Property property) {
        this.property = property;
        addressID.setText(property.getAddress());
        priceNumber.setText("" + property.getPricing());
    }
}
