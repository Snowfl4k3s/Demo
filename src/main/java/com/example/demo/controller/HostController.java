package com.example.demo.controller;

import com.example.demo.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HostController implements Initializable {
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
    private Button checkTenants;

    @FXML
    private GridPane grid;

    private List<PropertyTam> properties = new ArrayList<>();

    public void checkTenants(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/TenantCheck.fxml"));
        primaryStage.setTitle("Tenants");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void editProfile(MouseEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("/Profile.fxml");
    }

    private List<PropertyTam> getData() {
        List<PropertyTam> properties = new ArrayList<>();
        PropertyTam propertyTam;

        for (int i = 0; i < 50; i++) {
            //Lay data xuong xong thay vao cho nay
            //Can add them ca Host vca Owner nua
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

    private void setChosenProperty(PropertyTam propertyTam) {
        address.setText(propertyTam.getAddress());
        area.setText("" + propertyTam.getArea());
        bedroomCount.setText("" + propertyTam.getBedroom());
        if (propertyTam.isGarden()) {
            gardenBoolean.setText("Available");
        } else {
            gardenBoolean.setText("Not available");
        }
        parking.setText("" + propertyTam.getParking());
        if (propertyTam.isPets()) {
            pets.setText("Accept pets");
        } else {
            pets.setText("Pets not allowed");
        }
        price.setText("" + propertyTam.getPricing());
        type.setText(propertyTam.getType());
    }

    public void openProfile() throws IOException {
        Main m = new Main();
        m.changeScene("/Profile.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("a");
//        properties.addAll(getData());
//        if (properties.size() > 0) {
//            setChosenProperty(properties.get(0));
//        }
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