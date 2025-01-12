package com.example.demo.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentalAgreement {
    private String id;
    private Property property;
    private Tenant mainTenant;
    private Owner owner;
    private Host host;
    private String period; // Daily, Weekly, Monthly
    private Date contractDate;
    private double rentFee;
    private String status; // New, Active, Completed

    public RentalAgreement(String id, String period, Date contractDate, double rentFee, String status) {
        this.id = id;
        this.period = period;
        this.contractDate = contractDate;
        this.rentFee = rentFee;
        this.status = status;
    }

    public RentalAgreement(){
        id = "000";
        period = "Weekly";

        status = "New";
    }

    // Getters and Setters
    public String getAgreementId() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Tenant getMainTenant() {
        return mainTenant;
    }

    public void setMainTenant(Tenant mainTenant) {
        this.mainTenant = mainTenant;
    }


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Host getHost(){return host;}

    public void setHost(Host host) {
        this.host = host;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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

    public double getRentFee() {
        return rentFee;
    }

    public void setRentFee(double rentFee) {
        this.rentFee = rentFee;
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
                "%-15s%-20s%-35s%-15s%-20s%-15s%-20s%-15s",
                id,
                mainTenant.getFullName(),
                property.getAddress(),
                period,
                formattedDate,
                rentFee,
                status
        );
    }
}
