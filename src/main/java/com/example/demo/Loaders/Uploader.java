package com.example.demo.Loaders;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class Uploader {
    static String databaseUrl = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:5432/postgres?user=postgres.colexklzjdwbivpecfon&password=YCLFiGjaWefonw7u";
    static String supabaseUrl = "https://colexklzjdwbivpecfon.supabase.co";
    static String supabaseApiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNvbGV4a2x6amR3Yml2cGVjZm9uIiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTczNjMyNjY4MiwiZXhwIjoyMDUxOTAyNjgyfQ.02A7SIZOYZY53dIdyEKO6jgYlJrYRSrdB0P_yLto_Lw";
    static String bucketName = "Property image";
    public static void uploadImage(String filePath, String fileName, int propertyId) {
        String imgUrl;
        try {
            File file = new File(filePath);
            byte[] fileData = Files.readAllBytes(Paths.get(filePath));

            URL url = new URL(supabaseUrl + "/storage/v1/object/" + bucketName + "/" + fileName);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + supabaseApiKey);
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
            connection.setDoOutput(true);

            try (DataOutputStream out = new DataOutputStream(connection.getOutputStream())) {
                out.writeBytes("------WebKitFormBoundary7MA4YWxkTrZu0gW\r\n");
                out.writeBytes("Content-Disposition: form-data; name=\"file\"; filename=\"" + fileName + "\"\r\n");
                out.writeBytes("Content-Type: image/jpeg\r\n\r\n");
                out.write(fileData);
                out.writeBytes("\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--\r\n");
                out.flush();
            }

            // Read the response from the server
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Image uploaded successfully.");
                imgUrl = supabaseUrl + "/storage/v1/object/public/" + bucketName + "/" + fileName;
            } else {
                System.out.println("Failed to upload image. Response Code: " + responseCode);
                return;
            }

        } catch (IOException e) {
            System.err.println("Error uploading image: " + e.getMessage());
            return;
        }

        String updateQuery = "UPDATE Properties SET \"Image URL\" = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(databaseUrl);
             PreparedStatement stmt = conn.prepareStatement(updateQuery)) {

            stmt.setString(1, imgUrl);      // Set the Image URL
            stmt.setInt(2, propertyId);      // Set the Property ID

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Image URL updated for Property ID " + propertyId);
            } else {
                System.out.println("No Property found with Property ID " + propertyId);
            }

        } catch (SQLException e) {
            System.err.println("Error updating Property table: " + e.getMessage());
        }

    }

    /*public static void main(String[] args) {
        String imagePath = "Bruh.jpg";
        String imageName = "Building.jpg"; // Specify the name for the image in Supabase
        uploadImage(imagePath, imageName);
    }*/
}