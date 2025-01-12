package com.example.demo.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment {
    private int paymentId;
    private int tenantId;
    private int propertyId;
    private Date date;
    private String paymentMethod; // e.g., Cash, Credit Card, Bank Transfer

    public Payment(int paymentId, Date date, String paymentMethod) {
        this.paymentId = paymentId;
        this.date = date;
        this.paymentMethod = paymentMethod;
    }
    public Payment(){

    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getTenantId() {return tenantId;}

    public void setTenantId(int tenantId) {this.tenantId = tenantId;}

    public int getPropertyId() {return propertyId;}

    public void setPropertyId(int propertyId) {this.propertyId = propertyId;}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        //Formatting date and display
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(date); // Formats the Date object

        return String.format(
                "%-15s%-25s%-30s",
                paymentId,
                formattedDate,
                paymentMethod
        );
    }
}
