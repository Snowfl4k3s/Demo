package com.example.demo.controller;

import com.example.demo.MyListener;
import com.example.demo.models.Property;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PropertiesController {
    @FXML
    private Label addressID;

    @FXML
    private Label priceNumber;

    @FXML
    private ImageView houseImg;

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

        Image img = new Image(property.getImageUrl(), true);
        houseImg.setImage(img);

        houseImg.setFitWidth(170);
        houseImg.setPreserveRatio(true);
    }
}
