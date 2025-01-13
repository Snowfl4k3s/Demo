package com.example.demo.Loaders;
import java.sql.*;

import java.sql.Date;


public class Editor {
    static String databaseUrl = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:5432/postgres?user=postgres.colexklzjdwbivpecfon&password=YCLFiGjaWefonw7u";

    public static void updateUser(int userId, String Name, String dob, String email, String password) {
        String updateQuery = "UPDATE \"Rental Management User\" SET \"Name\" = ?, \"D_O_B\" = ?, \"email\" = ?, \"Password\" = ? WHERE id = ?";
        Date dateOfBirth = Date.valueOf(dob);

        try (Connection conn = DriverManager.getConnection(databaseUrl);
             PreparedStatement stmt = conn.prepareStatement(updateQuery)) {

            // Set the parameters for the query
            stmt.setString(1, Name);     // Set the Name
            stmt.setDate(2, dateOfBirth);      // Set the Date of Birth
            stmt.setString(3, email);    // Set the Email
            stmt.setString(4, password); // Set the Password
            stmt.setInt(5, userId);      // Set the User ID

            // Execute the update query
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User data updated successfully.");
            } else {
                System.out.println("No user found with User ID " + userId);
            }

        } catch (SQLException e) {
            System.err.println("Error updating user data: " + e.getMessage());
        }
    }

    public static void updateProperty(int propertyId, String address, int pricing, int hostId,
                                      String propertyType, String imageUrl, Integer bedrooms,
                                      Boolean petFriendly, Boolean availGarden, String businessType,
                                      Integer parkingSpace, Float squareFt) {
        try (Connection conn = DriverManager.getConnection(databaseUrl)) {
            System.out.println("Connected to the database!");

            // Determine the correct SQL query based on the PropertyType
            String sql;
            if ("Residential".equalsIgnoreCase(propertyType)) {
                sql = "UPDATE \"Properties\" SET \"Address\" = ?, \"Pricing\" = ?, \"Hosted by\" = ?, \"Property Type\" = ?, \"Image URL\" = ?, " +
                        "\"No.Bedrooms\" = ?, \"Pet.Friendly\" = ?, \"Avail.Garden\" = ? WHERE \"id\" = ?";
            } else if ("Commercial".equalsIgnoreCase(propertyType)) {
                sql = "UPDATE \"Properties\" SET \"Address\" = ?, \"Pricing\" = ?, \"Hosted by\" = ?, \"Property Type\" = ?, \"Image URL\" = ?, " +
                        "\"Business.Ty\" = ?, \"Parking.Space\" = ?, \"Square.Ft\" = ? WHERE \"id\" = ?";
            } else {
                System.out.println("Invalid property type. Use 'Residential' or 'Commercial'.");
                return; // Exit early if the property type is invalid
            }

            // Use PreparedStatement for safe parameter insertion
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                // Set basic parameters
                stmt.setString(1, address);
                stmt.setInt(2, pricing);
                stmt.setInt(3, hostId);
                stmt.setString(4, propertyType);
                stmt.setString(5, imageUrl);

                // Set additional parameters based on the property type
                if ("Residential".equalsIgnoreCase(propertyType)) {
                    stmt.setInt(6, (bedrooms != null) ? bedrooms : 0); // No.Bedrooms, default to 0 if null
                    stmt.setBoolean(7, (petFriendly != null) ? petFriendly : false); // Pet.Friendly, default to false if null
                    stmt.setBoolean(8, (availGarden != null) ? availGarden : false); // Avail.Garden, default to false if null
                } else if ("Commercial".equalsIgnoreCase(propertyType)) {
                    stmt.setString(6, (businessType != null) ? businessType : null); // Business.Ty
                    stmt.setInt(7, (parkingSpace != null) ? parkingSpace : 0); // Parking.Space, default to 0 if null
                    stmt.setFloat(8, (squareFt != null) ? squareFt : 0f); // Square.Ft, default to 0f if null
                }

                // Set the property ID in the WHERE clause to identify the correct property
                stmt.setInt(9, propertyId);

                // Execute the update query
                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Property updated successfully!");
                } else {
                    System.out.println("Failed to update property. No rows affected.");
                }
            } catch (SQLException e) {
                System.err.println("Error executing update: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }

    public static void updateRentalAgreement(int agreementId, String newStatus) {
        String sql = "UPDATE \"Rental Agreements\" " +
                "SET \"Status\" = ? " +
                "WHERE \"id\" = ?";

        try (Connection conn = DriverManager.getConnection(databaseUrl);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set parameters for the query
            stmt.setString(1, newStatus); // New status value
            stmt.setInt(2, agreementId);  // Agreement ID

            // Execute the update
            int rowsUpdated = stmt.executeUpdate();

            // Check the result
            if (rowsUpdated > 0) {
                System.out.println("Rental agreement updated successfully!");
            } else {
                System.out.println("No rental agreement found with the given AgreementId.");
            }

        } catch (SQLException e) {
            System.err.println("Error updating rental agreement: " + e.getMessage());
        }
    }




}
