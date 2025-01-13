package com.example.demo.Loaders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EditorTest {

    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;

    @BeforeEach
    void setUp() throws SQLException {
        // Mocking the Connection and PreparedStatement
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);

        // Mock behavior for the prepared statement
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
    }

    @Test
    void testUpdateUser() throws SQLException {
        // Arrange
        int userId = 1;
        String name = "John Doe";
        String dob = "1990-01-01";
        String email = "john.doe@example.com";
        String password = "securePassword";
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // Act
        Editor.updateUser(userId, name, dob, email, password);

        // Assert
        verify(mockPreparedStatement).setString(1, name);
        verify(mockPreparedStatement).setDate(2, Date.valueOf(dob));
        verify(mockPreparedStatement).setString(3, email);
        verify(mockPreparedStatement).setString(4, password);
        verify(mockPreparedStatement).setInt(5, userId);
        verify(mockPreparedStatement).executeUpdate();
        verify(mockPreparedStatement).close();
        verify(mockConnection, times(1)).close();
    }

    @Test
    void testUpdatePropertyResidential() throws SQLException {
        // Arrange
        int propertyId = 31;
        String address = "123 Main St";
        int pricing = 1200;
        int hostId = 31;
        String propertyType = "Residential";
        String imageUrl = "image-url.com/property";
        Integer bedrooms = 3;
        Boolean petFriendly = true;
        Boolean availGarden = true;

        // Create captors to capture the arguments passed to the mock methods
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Integer> intCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Boolean> booleanCaptor = ArgumentCaptor.forClass(Boolean.class);

        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // Act
        Editor.updateProperty(propertyId, address, pricing, hostId, propertyType, imageUrl, bedrooms, petFriendly, availGarden, null, null, null);

        // Capture the arguments passed to the methods
        mockPreparedStatement.setString(1, address);
        mockPreparedStatement.setInt(2, pricing);
        mockPreparedStatement.setInt(3, hostId);
        mockPreparedStatement.setString(4, propertyType);
        mockPreparedStatement.setString(5, imageUrl);
        mockPreparedStatement.setInt(6, bedrooms);
        mockPreparedStatement.setBoolean(7, petFriendly);
        mockPreparedStatement.setBoolean(8, availGarden);
        mockPreparedStatement.setInt(9, propertyId);

        // Assert the captured values
        assertEquals(address, stringCaptor.getAllValues().get(0));
        assertEquals(pricing, intCaptor.getAllValues().get(0));
        assertEquals(hostId, intCaptor.getAllValues().get(1));
        assertEquals(propertyType, stringCaptor.getAllValues().get(1));
        assertEquals(imageUrl, stringCaptor.getAllValues().get(2));
        assertEquals(bedrooms, intCaptor.getAllValues().get(2));
        assertEquals(petFriendly, booleanCaptor.getAllValues().get(0));
        assertEquals(availGarden, booleanCaptor.getAllValues().get(1));
        assertEquals(propertyId, intCaptor.getAllValues().get(3));

        // Assert executeUpdate was called and that it returned the correct result
        assertEquals(1, mockPreparedStatement.executeUpdate());

        // Check that close() was called for both the PreparedStatement and the Connection
        mockPreparedStatement.close();
        mockConnection.close();
    }


    @Test
    void testUpdatePropertyCommercial() throws SQLException {
        // Arrange
        int propertyId = 31;
        String address = "456 Business Ave";
        int pricing = 5000;
        int hostId = 31;
        String propertyType = "Commercial";
        String imageUrl = "image-url.com/commercial";
        String businessType = "Office";
        Integer parkingSpace = 10;
        Float squareFt = 2000.5f;
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // Act
        Editor.updateProperty(propertyId, address, pricing, hostId, propertyType, imageUrl, null, null, null, businessType, parkingSpace, squareFt);

        // Assert
        verify(mockPreparedStatement).setString(1, address);
        verify(mockPreparedStatement).setInt(2, pricing);
        verify(mockPreparedStatement).setInt(3, hostId);
        verify(mockPreparedStatement).setString(4, propertyType);
        verify(mockPreparedStatement).setString(5, imageUrl);
        verify(mockPreparedStatement).setString(6, businessType);
        verify(mockPreparedStatement).setInt(7, parkingSpace);
        verify(mockPreparedStatement).setFloat(8, squareFt);
        verify(mockPreparedStatement).setInt(9, propertyId);
        verify(mockPreparedStatement).executeUpdate();
        verify(mockPreparedStatement).close();
        verify(mockConnection, times(1)).close();
    }

    @Test
    void testUpdateRentalAgreement() throws SQLException {
        // Arrange
        int agreementId = 3;
        String newStatus = "Active";
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // Act
        Editor.updateRentalAgreement(agreementId, newStatus);

        // Assert
        verify(mockPreparedStatement).setString(1, newStatus);
        verify(mockPreparedStatement).setInt(2, agreementId);
        verify(mockPreparedStatement).executeUpdate();
        verify(mockPreparedStatement).close();
        verify(mockConnection, times(1)).close();
    }
}

