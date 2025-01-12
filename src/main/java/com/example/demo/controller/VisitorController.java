package com.example.demo.controller;

import com.example.demo.Loaders.DataLoader;
import com.example.demo.Main;
import com.example.demo.models.Property;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class VisitorController implements Initializable {
    @FXML
    private Label address;

    @FXML
    private Label area;

    @FXML
    private Label bedroomCount;

    @FXML
    private Label gardenBoolean;

    @FXML
    private Label host;

    @FXML
    private Label owner;

    @FXML
    private Label parking;

    @FXML
    private Label pets;

    @FXML
    private Label price;

    @FXML
    private ImageView profile;

    @FXML
    private Label type;

    @FXML
    private Label username;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    List<Property> PropertyList = DataLoader.loadProperties();
    private List<Property> getData() {

        for (Property Property : PropertyList) {
            Property property = new Property();
            property.setId(Property.getId());
            property.setAddress(Property.getAddress());
            property.setPricing(Property.getPricing());
            property.setAvailability(Property.getAvailability());
            property.setHostedBy(Property.getHostedBy());
            property.setOwnedBy(Property.getOwnedBy());
            property.setBedroom(Property.getBedroom());
            property.setGarden(Property.isGarden());
            property.setPets(Property.isPets());
            property.setBuisnessType(Property.getBuisnessType());
            property.setParking(Property.getParking());
            property.setArea(Property.getArea());
            property.setType(Property.getType());
            property.setImageUrl(Property.getImageUrl());
        }
        return PropertyList;
    }

//    private List<PropertyTam> properties = new ArrayList<>();
//
//    private List<PropertyTam> getData() {
//        List<PropertyTam> properties = new ArrayList<>();
//        PropertyTam propertyTam;
//
//        for(int i = 0; i < 50; i++){
//            //Lay data xuong xong thay vao cho nay
//            //Can add them ca Host vca Owner nua
//            propertyTam = new PropertyTam();
//            propertyTam.setAddress("a");
//            propertyTam.setPricing(3);
//            propertyTam.setAvailability("a");
//            propertyTam.setBedroom(3);
//            propertyTam.setGarden(true);
//            propertyTam.setPets(true);
//            propertyTam.setType("Office");
//            propertyTam.setParking(3);
//            propertyTam.setArea(3);
//            properties.add(propertyTam);
//        }
//
//        return properties;
//    }
//
    private void setChosenProperty(Property property) {
        address.setText(property.getAddress());
        area.setText("" + property.getArea());
        bedroomCount.setText("" + property.getBedroom());
        if (property.isGarden()) {
            gardenBoolean.setText("Available");
        }
        else {
            gardenBoolean.setText("Not available");
        }
        parking.setText("" + property.getParking());
        if (property.isPets()) {
            pets.setText("Accept pets");
        }
        else {
            pets.setText("Pets not allowed");
        }
        price.setText("" + property.getPricing());
        type.setText(property.getType());
    }

    public void openProfile() throws IOException {
        Main m = new Main();
        m.changeScene("/Profile.fxml");
    }
//
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("a");
        PropertyList.addAll(getData());
        if (PropertyList.size() > 0){
            setChosenProperty(PropertyList.get(0));
        }
        int column = 0;
        int row = 0;
        try {
            for (int i = 0; i<PropertyList.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/propertiesLoad.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();

                PropertiesController propertiesController = fxmlLoader.getController();
                propertiesController.setData(PropertyList.get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row);

                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
