package com.example.demo.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tenant extends Person{
    private List<Payment> paymentRecords;
    public Tenant(String id, String fullName, Date dateOfBirth, String contactInfo) {
        super(id, fullName, dateOfBirth, contactInfo);
        this.paymentRecords = new ArrayList<>();
    }
    public Tenant(){
        super();
        this.paymentRecords = new ArrayList<>();
    }

    // Getters and Setters

    public List<Payment> getPaymentRecords() {
        return paymentRecords;
    }

    public void setPaymentRecords(List<Payment> paymentRecords) {
        this.paymentRecords = paymentRecords;
    }

    // Methods to add agreements or payments

    public void addPayment(Payment payment) {
        this.paymentRecords.add(payment);
    }
    // Getters and Setters
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
