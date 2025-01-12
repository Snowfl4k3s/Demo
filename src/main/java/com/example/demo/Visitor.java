package com.example.demo;

import com.example.demo.models.Property;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Visitor implements Initializable {
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

    private List<Property> properties = new ArrayList<>();

    private List<Property> getData() {
        List<Property> properties = new ArrayList<>();
        Property property;

        for(int i = 0; i < 50; i++){
            //Lay data xuong xong thay vao cho nay
            //Can add them ca Host vca Owner nua
            property = new Property();
            property.setAddress("a");
            property.setPricing(3);
            property.setAvailability("a");
            property.setBedroom(3);
            property.setGarden(true);
            property.setPets(true);
            property.setType("Office");
            property.setParking(3);
            property.setArea(3);
            properties.add(property);
        }

        return properties;
    }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("a");
        properties.addAll(getData());
        if (properties.size() > 0){
            setChosenProperty(properties.get(0));
        }
        int column = 0;
        int row = 0;
        try {
            for (int i = 0; i<properties.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/propertiesLoad.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();

                PropertiesController propertiesController = fxmlLoader.getController();
                propertiesController.setData(properties.get(i));

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
