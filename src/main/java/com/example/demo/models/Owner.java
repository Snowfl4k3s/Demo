package com.example.demo.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Owner extends Person {
    private List<Property> ownedProperties;
    private List<RentalAgreement> rentalAgreements;

    public Owner(String id, String fullName, Date dateOfBirth, String contactInfo) {
        super(id, fullName, dateOfBirth, contactInfo);
        this.ownedProperties = new ArrayList<>();
        this.rentalAgreements = new ArrayList<>();
    }

    // Getters and Setters
    public List<Property> getOwnedProperties() {
        return ownedProperties;
    }

    public void setOwnedProperties(List<Property> ownedProperties) {
        this.ownedProperties = ownedProperties;
    }


    public List<RentalAgreement> getRentalAgreements() {
        return rentalAgreements;
    }

    public void setRentalAgreements(List<RentalAgreement> rentalAgreements) {
        this.rentalAgreements = rentalAgreements;
    }

    // Methods to add properties, hosts, and agreements
    public void addOwnedProperty(Property property) {
        this.ownedProperties.add(property);
    }

    public void addRentalAgreement(RentalAgreement agreement) {
        this.rentalAgreements.add(agreement);
    }

    @Override
    public String toString() {
        //Formatting date and display
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(super.dateOfBirth); // Formats the Date object

        return String.format(
                "%-15s%-20s%-25s%-30s",
                super.id,                // Tenant ID
                super.fullName,          // Tenant Name
                formattedDate,           // Formatted Date of Birth for display
                super.contactInfo        // Contact Information
        );
    }
}
