package com.example.demo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tenant extends Person{
    private List<Payment> paymentRecords;
    public Tenant(String id, String fullName, Date dateOfBirth, String contactInfo) {
        super(id, fullName, dateOfBirth, contactInfo);
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
}
