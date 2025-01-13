package com.example.demo.Loaders;


import com.example.demo.models.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataLoader {
    public static List<Tenant> loadTenants() {
        List<Tenant> tenants = new ArrayList<>();
        String supabaseUrl = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:5432/postgres?user=postgres.colexklzjdwbivpecfon&password=YCLFiGjaWefonw7u";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(supabaseUrl);
            System.out.println("Connected to the database!");

            String query = "SELECT * FROM \"Rental Management User\"";
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                    if (rs.getString("Role").equals("Tenant")) {
                        //System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
                        Tenant tenant = new Tenant();
                        tenant.setId(rs.getString("id"));
                        tenant.setFullName(rs.getString("Name"));
                        tenant.setDateOfBirth(rs.getDate("D_O_B"));
                        tenant.setContactInfo(rs.getString("email"));

                        tenants.add(tenant);

                    }
                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        } finally {
            // Close the connection in the `finally` block to ensure it's always closed
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace(); // Handle exceptions when closing
                }
            }
        }
        return tenants;
    }

    public static List<Owner> loadOwners() {
        List<Owner> owners = new ArrayList<>();
        String supabaseUrl = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:5432/postgres?user=postgres.colexklzjdwbivpecfon&password=YCLFiGjaWefonw7u";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(supabaseUrl);
            System.out.println("Connected to the database!");

            String query = "SELECT * FROM \"Rental Management User\"";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    if (rs.getString("Role").equals("Owner")) {
                        //System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
                        Owner owner = new Owner();
                        owner.setId(rs.getString("id"));
                        owner.setFullName(rs.getString("Name"));
                        owner.setDateOfBirth(rs.getDate("D_O_B"));
                        owner.setContactInfo(rs.getString("email"));

                        owners.add(owner);

                    }
                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        } finally {
            // Close the connection in the `finally` block to ensure it's always closed
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace(); // Handle exceptions when closing
                }
            }
        }
        return owners;
    }

    public static List<Host> loadHosts() {
        List<Host> hosts = new ArrayList<>();
        String supabaseUrl = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:5432/postgres?user=postgres.colexklzjdwbivpecfon&password=YCLFiGjaWefonw7u";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(supabaseUrl);
            System.out.println("Connected to the database!");

            String query = "SELECT * FROM \"Rental Management User\"";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    if (rs.getString("Role").equals("Host")) {
                        //System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
                        Host host = new Host();
                        host.setId(rs.getString("id"));
                        host.setFullName(rs.getString("Name"));
                        host.setDateOfBirth(rs.getDate("D_O_B"));
                        host.setContactInfo(rs.getString("email"));

                        hosts.add(host);

                    }
                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        } finally {
            // Close the connection in the `finally` block to ensure it's always closed
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace(); // Handle exceptions when closing
                }
            }
        }
        return hosts;
    }


    public static List<Property> loadProperties() {
        List<Property> properties = new ArrayList<>();
        String supabaseUrl = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:5432/postgres?user=postgres.colexklzjdwbivpecfon&password=YCLFiGjaWefonw7u";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(supabaseUrl);
            System.out.println("Connected to the database!");

            String query = "SELECT * FROM \"Properties\"";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                        //System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
                        Property property = new Property();
                        property.setId(rs.getInt("id"));
                        property.setAddress(rs.getString("Address"));
                        property.setPricing(rs.getInt("Pricing"));
                        property.setAvailability(rs.getString("Availability"));
                        property.setHostedBy(rs.getInt("Hosted by"));
                        property.setOwnedBy(rs.getInt("Owned by"));
                        property.setImageUrl(rs.getString("Image URL"));
                        property.setType(rs.getString("Property Type"));
                        if(property.getType().equals("Residential")){
                            property.setBedroom(rs.getInt("No.Bedrooms"));
                            property.setGarden(rs.getBoolean("Avail.Garden"));
                            property.setPets(rs.getBoolean("Pet.Friendly"));
                        }
                        else {
                            property.setBuisnessType(rs.getString("Business.Ty"));
                            property.setParking(rs.getInt("Parking.Space"));
                            property.setArea(rs.getFloat("Square.Ft"));
                        }
                        properties.add(property);
                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        } finally {
            // Close the connection in the `finally` block to ensure it's always closed
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace(); // Handle exceptions when closing
                }
            }
        }
        return properties;
    }

    public static List<RentalAgreement> loadRentalAgreements() {
        List<RentalAgreement> rentalAgreements = new ArrayList<>();
        String supabaseUrl = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:5432/postgres?user=postgres.colexklzjdwbivpecfon&password=YCLFiGjaWefonw7u";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(supabaseUrl);
            System.out.println("Connected to the database!");

            String query = "SELECT * FROM \"Rental Agreements\"";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {

                        //System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
                        RentalAgreement rentalAgreement = new RentalAgreement();
                        rentalAgreement.setid(rs.getInt("id"));
                        rentalAgreement.setProperty(rs.getInt("Property"));
                        rentalAgreement.setMainTenant(rs.getInt("Tenant"));
                        rentalAgreement.setHost(rs.getInt("Host"));
                        rentalAgreement.setOwner(rs.getInt("Owner"));
                        rentalAgreement.setContractDate(rs.getDate("Date Leased"));
                        rentalAgreement.setStatus(rs.getString("Status"));

                    rentalAgreements.add(rentalAgreement);


                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        } finally {
            // Close the connection in the `finally` block to ensure it's always closed
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace(); // Handle exceptions when closing
                }
            }
        }
        return rentalAgreements;
    }
    public static List<Payment> loadPayments() {
        List<Payment> payments = new ArrayList<>();
        String supabaseUrl = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:5432/postgres?user=postgres.colexklzjdwbivpecfon&password=YCLFiGjaWefonw7u";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(supabaseUrl);
            System.out.println("Connected to the database!");

            String query = "SELECT * FROM \"Rental Management User\"";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {

                        //System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
                        Payment payment = new Payment();
                        payment.setPaymentId(rs.getInt("id"));
                        payment.setTenantId(rs.getInt("Tenant"));
                        payment.setPropertyId(rs.getInt("Property"));
                        payment.setDate(rs.getDate("Date Paid"));
                        payment.setPaymentMethod(rs.getString("PaymentMethod"));

                        payments.add(payment);


                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        } finally {
            // Close the connection in the `finally` block to ensure it's always closed
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace(); // Handle exceptions when closing
                }
            }
        }
        return payments;
    }
}
