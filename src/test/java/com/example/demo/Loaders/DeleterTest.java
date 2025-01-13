package com.example.demo.Loaders;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

    class DeleterTest {

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
        void testDeleteRentalAgreement() throws SQLException {
            // Arrange
            int agreementId = 15;
            when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
            when(mockPreparedStatement.executeUpdate()).thenReturn(1);

            // Act
            Deleter.deleteRentalAgreement(agreementId);

            // Assert
            verify(mockPreparedStatement).setInt(1, agreementId);
            verify(mockPreparedStatement).executeUpdate();
            verify(mockPreparedStatement).close();
            verify(mockConnection, times(1)).close();
        }

        @Test
        void testDeleteProperty() throws SQLException {
            // Arrange
            int propertyId = 1;
            when(mockPreparedStatement.executeUpdate()).thenReturn(1);

            // Act
            Deleter.deleteProperty(propertyId);

            // Assert
            verify(mockPreparedStatement).setInt(1, propertyId);
            verify(mockPreparedStatement).executeUpdate();
            verify(mockPreparedStatement).close();
            verify(mockConnection, times(1)).close();
        }

        @Test
        void testDeleteUser() throws SQLException {
            // Arrange
            int userId = 1;
            when(mockPreparedStatement.executeUpdate()).thenReturn(1);

            // Act
            Deleter.deleteUser(userId);

            // Assert
            verify(mockPreparedStatement).setInt(1, userId);
            verify(mockPreparedStatement).executeUpdate();
            verify(mockPreparedStatement).close();
            verify(mockConnection, times(1)).close();
        }

        @Test
        void testDeletePayment() throws SQLException {
            // Arrange
            int paymentId = 1;
            when(mockPreparedStatement.executeUpdate()).thenReturn(1);

            // Act
            Deleter.deletePayment(paymentId);

            // Assert
            verify(mockPreparedStatement).setInt(1, paymentId);
            verify(mockPreparedStatement).executeUpdate();
            verify(mockPreparedStatement).close();
            verify(mockConnection, times(1)).close();
        }
    }


