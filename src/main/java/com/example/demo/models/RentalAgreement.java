package com.example.demo.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RentalAgreement {
    private int id;
    private int propertyId;
    private int tenantId;
    private int ownerId;
    private int hostId;
    private Date contractDate;

    private String status; // Ongoing or Completed

    public RentalAgreement(int id, Date contractDate, String status) {
        this.id = id;
        this.contractDate = contractDate;
        this.status = status;
    }

    public RentalAgreement(){
        id = 0;
        status = "Ongoing";
    }

    // Getters and Setters
    public int getAgreementId() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getProperty() {
        return propertyId;
    }

    public void setProperty(int property) {
        this.propertyId = property;
    }

    public int getMainTenant() {
        return tenantId;
    }

    public void setMainTenant(int mainTenant) {
        this.tenantId = mainTenant;
    }


    public int getOwner() {
        return ownerId;
    }

    public void setOwner(int owner) {
        this.ownerId = owner;
    }

    public int getHost(){return hostId;}

    public void setHost(int host) {
        this.hostId = host;
    }



    public Date getContractDate() {
        return contractDate;
    }

    public String getContractDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(contractDate); // Formats the Date object
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        //Formatting date and display
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(contractDate); // Formats the Date object

        return String.format(
                "%-15s%-20s%-35s%-15s%-20s%-15s",
                id,
                tenantId,
                propertyId,
                formattedDate,
                status
        );
    }
}
