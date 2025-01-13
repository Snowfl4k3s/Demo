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

}
