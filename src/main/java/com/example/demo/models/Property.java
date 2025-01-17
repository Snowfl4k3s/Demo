package com.example.demo.models;

public class Property {
    private int id;
    private String address;
    private int pricing;
    private String availability;
    private int hostedBy;
    private int ownedBy;
    private int bedroom;
    private boolean garden;
    private boolean pets;
    private String buisnessType;
    private int parking;
    private float area;
    private String type;
    private String imageUrl;

    public Property() {

    }

    public String getImageUrl() {return imageUrl;}

    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPricing() {
        return pricing;
    }

    public void setPricing(int pricing) {
        this.pricing = pricing;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public boolean isGarden() {
        return garden;
    }

    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    public boolean isPets() {
        return pets;
    }

    public void setPets(boolean pets) {
        this.pets = pets;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getBuisnessType() {return buisnessType;}

    public void setBuisnessType(String buisnessType) {this.buisnessType = buisnessType;}

    public int getHostedBy() {return hostedBy;}

    public void setHostedBy(int hostedBy) {this.hostedBy = hostedBy;}

    public int getOwnedBy() {return ownedBy;}

    public void setOwnedBy(int ownedBy) {this.ownedBy = ownedBy;}
}
