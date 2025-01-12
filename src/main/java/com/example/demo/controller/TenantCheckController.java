package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TenantCheckController implements Initializable {

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;


    private List<PropertyTam> properties = new ArrayList<>();

    private List<PropertyTam> getData() {
        List<PropertyTam> properties = new ArrayList<>();
        PropertyTam propertyTam;

        for (int i = 0; i < 50; i++) {
            //Thay cai nay bang tenants
            propertyTam = new PropertyTam();
            propertyTam.setAddress("a");
            propertyTam.setPricing(3);
            propertyTam.setAvailability("a");
            propertyTam.setBedroom(3);
            propertyTam.setGarden(true);
            propertyTam.setPets(true);
            propertyTam.setType("Office");
            propertyTam.setParking(3);
            propertyTam.setArea(3);
            properties.add(propertyTam);
        }

        return properties;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("a");
//        properties.addAll(getData());
//        int column = 0;
//        int row = 0;
//        try {
//            for (int i = 0; i < properties.size(); i++) {
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                fxmlLoader.setLocation(getClass().getResource("/propertiesLoad.fxml"));
//                AnchorPane anchorPane = fxmlLoader.load();
//
//                PropertiesController propertiesController = fxmlLoader.getController();
//                propertiesController.setData(properties.get(i));
//
//                if (column == 3) {
//                    column = 0;
//                    row++;
//                }
//                grid.add(anchorPane, column++, row);
//
//                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
//                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
//                grid.setMaxHeight(Region.USE_PREF_SIZE);
//
//                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
//                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
//                grid.setMaxWidth(Region.USE_PREF_SIZE);
//
//                GridPane.setMargin(anchorPane, new Insets(10));
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
