package com.example.demo.Loaders;
import org.junit.jupiter.api.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import java.io.File;
import java.sql.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TestUploader {

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockStatement;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUploadImage_Success() throws Exception {
        // Arrange
        String filePath = "test.jpg";
        String fileName = "uploaded_test.jpg";
        int propertyId = 1;

        File testFile = new File(filePath);
        testFile.createNewFile(); // Create a temporary test file

        try (MockedStatic<DriverManager> driverManagerMock = mockStatic(DriverManager.class)) {
            driverManagerMock.when(() -> DriverManager.getConnection(anyString())).thenReturn(mockConnection);
            when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
            when(mockStatement.executeUpdate()).thenReturn(1);

            // Act
            Uploader.uploadImage(filePath, fileName, propertyId);

            // Assert
            verify(mockStatement).setString(eq(1), anyString()); // Verify the URL parameter
            verify(mockStatement).setInt(eq(2), eq(propertyId)); // Verify the property ID
            verify(mockStatement).executeUpdate();
        }

        // Cleanup
        testFile.delete();
    }

    @Test
    void testUploadImage_FileNotFound() {
        // Arrange
        String filePath = "non_existent.jpg";
        String fileName = "non_existent_test.jpg";
        int propertyId = 1;

        // Act & Assert
        assertDoesNotThrow(() -> Uploader.uploadImage(filePath, fileName, propertyId));
    }

    @Test
    void testUploadProperty_Residential_Success() throws Exception {
        // Arrange
        String address = "123 Test Street";
        int pricing = 1500;
        int hostId = 2;
        int ownerId = 3;
        String propertyType = "Residential";
        String imageUrl = "http://example.com/image.jpg";
        int bedrooms = 3;
        boolean petFriendly = true;
        boolean availGarden = true;

        try (MockedStatic<DriverManager> driverManagerMock = mockStatic(DriverManager.class)) {
            driverManagerMock.when(() -> DriverManager.getConnection(anyString())).thenReturn(mockConnection);
            when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
            when(mockStatement.executeUpdate()).thenReturn(1);

            // Act
            Uploader.uploadProperty(address, pricing, hostId, ownerId, propertyType, imageUrl, bedrooms, petFriendly, availGarden, null, null, null);

            // Assert
            verify(mockStatement).setString(eq(1), eq(address));
            verify(mockStatement).setInt(eq(2), eq(pricing));
            verify(mockStatement).setInt(eq(3), eq(hostId));
            verify(mockStatement).setInt(eq(4), eq(ownerId));
            verify(mockStatement).setString(eq(5), eq(propertyType));
            verify(mockStatement).setString(eq(6), eq(imageUrl));
            verify(mockStatement).setInt(eq(7), eq(bedrooms));
            verify(mockStatement).setBoolean(eq(8), eq(petFriendly));
            verify(mockStatement).setBoolean(eq(9), eq(availGarden));
        }
    }

    @Test
    void testUploadRentalAgreement_ValidInput_Success() throws Exception {
        // Arrange
        int tenantId = 1;
        int propertyId = 2;
        String dateLeased = "2023-01-01";
        String status = "Ongoing";
        int hostId = 3;

        try (MockedStatic<DriverManager> driverManagerMock = mockStatic(DriverManager.class)) {
            driverManagerMock.when(() -> DriverManager.getConnection(anyString())).thenReturn(mockConnection);
            when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
            when(mockStatement.executeUpdate()).thenReturn(1);

            // Act
            Uploader.uploadRentalAgreement(tenantId, propertyId, dateLeased, status, hostId);

            // Assert
            verify(mockStatement).setInt(eq(1), eq(tenantId));
            verify(mockStatement).setInt(eq(2), eq(propertyId));
            verify(mockStatement).setDate(eq(3), eq(Date.valueOf(dateLeased)));
            verify(mockStatement).setString(eq(4), eq(status));
            verify(mockStatement).setInt(eq(5), eq(hostId));
        }
    }

    @Test
    void testUploadRentalAgreement_InvalidStatus() {
        // Arrange
        int tenantId = 1;
        int propertyId = 2;
        String dateLeased = "2023-01-01";
        String status = "InvalidStatus";
        int hostId = 3;

        // Act & Assert
        assertDoesNotThrow(() -> Uploader.uploadRentalAgreement(tenantId, propertyId, dateLeased, status, hostId));
    }
}
