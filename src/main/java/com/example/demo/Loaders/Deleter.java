package com.example.demo.Loaders;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;


public class Deleter {
    static String databaseUrl = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:5432/postgres?user=postgres.colexklzjdwbivpecfon&password=YCLFiGjaWefonw7u";
    public static void deleteRentalAgreement(int agreementId) {
        String sql = "DELETE FROM \"Rental Agreements\" WHERE \"id\" = ?";

        try (Connection conn = DriverManager.getConnection(databaseUrl);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set the AgreementId parameter
            stmt.setInt(1, agreementId);

            // Execute the delete query
            int rowsDeleted = stmt.executeUpdate();

            // Check if the deletion was successful
            if (rowsDeleted > 0) {
                System.out.println("Rental agreement deleted successfully!");
            } else {
                System.out.println("No rental agreement found with the given AgreementId.");
            }

        } catch (SQLException e) {
            System.err.println("Error deleting rental agreement: " + e.getMessage());
        }
    }

    public static void deleteProperty(int propertyId) {
        String sql = "DELETE FROM \"Properties\" WHERE \"id\" = ?";

        try (Connection conn = DriverManager.getConnection(databaseUrl);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set the PropertyId parameter
            stmt.setInt(1, propertyId);

            // Execute the delete query
            int rowsDeleted = stmt.executeUpdate();

            // Check if the deletion was successful
            if (rowsDeleted > 0) {
                System.out.println("Property deleted successfully!");
            } else {
                System.out.println("No property found with the given Id.");
            }

        } catch (SQLException e) {
            System.err.println("Error deleting property: " + e.getMessage());
        }
    }

    public static void deleteUser(int userId) {
        String sql = "DELETE FROM \"Rental Management User\" WHERE \"id\" = ?";

        try (Connection conn = DriverManager.getConnection(databaseUrl);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set the UserId parameter
            stmt.setInt(1, userId);

            // Execute the delete query
            int rowsDeleted = stmt.executeUpdate();

            // Check if the deletion was successful
            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully!");
            } else {
                System.out.println("No user found with the given Id.");
            }

        } catch (SQLException e) {
            System.err.println("Error deleting user: " + e.getMessage());
        }
    }

    public static void deletePayment(int paymentId) {
        String sql = "DELETE FROM \"Payments\" WHERE \"id\" = ?";

        try (Connection conn = DriverManager.getConnection(databaseUrl);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set the PaymentId parameter
            stmt.setInt(1, paymentId);

            // Execute the delete query
            int rowsDeleted = stmt.executeUpdate();

            // Check if the deletion was successful
            if (rowsDeleted > 0) {
                System.out.println("Payment deleted successfully!");
            } else {
                System.out.println("No payment found with the given Id.");
            }

        } catch (SQLException e) {
            System.err.println("Error deleting payment: " + e.getMessage());
        }
    }


}
