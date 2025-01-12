package com.example.demo.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment {
    private String paymentId;

    private Date date;
    private String paymentMethod; // e.g., Cash, Credit Card, Bank Transfer

    public Payment(String paymentId, Date date, String paymentMethod) {
        this.paymentId = paymentId;
        this.date = date;
        this.paymentMethod = paymentMethod;
    }

    // Getters and Setters
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }





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
