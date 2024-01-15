package com.counterhost.DbConnections.DbWorkers;

import com.counterhost.DbConnections.DatabaseConnectionPool;
import com.counterhost.Application.ShopEngine.Basket.Basket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BasketDb {

    public long addBasket(Basket basket) throws SQLException {
        String sql = "INSERT INTO Basket (timeOpenBasket, timeCloseBasket, timePaidBasket, timeCancelledBasket, isBasketOpen, isBasketPaid, isBasketCancelled, basketOwnerId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnectionPool.getDataSource().getConnection();
             PreparedStatement statement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            NullerCheckerTimeStamp(basket, statement);
            statement.setObject(8, basket.getBasketOwnerId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating basket failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating basket failed, no ID obtained.");
                }
            }
        }
    }

    public Basket getBasket(long basketNr) throws SQLException {
        String sql = "SELECT * FROM Basket WHERE basketNr = ?";
        try (Connection conn = DatabaseConnectionPool.getDataSource().getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setLong(1, basketNr);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Basket basket = new Basket();
                    basket.setBasketNr(resultSet.getLong("basketNr"));
                    basket.setTimeOpenBasket(resultSet.getTimestamp("timeOpenBasket") != null ? resultSet.getTimestamp("timeOpenBasket").toLocalDateTime() : null);
                    basket.setTimeCloseBasket(resultSet.getTimestamp("timeCloseBasket") != null ? resultSet.getTimestamp("timeCloseBasket").toLocalDateTime() : null);
                    basket.setTimePaidBasket(resultSet.getTimestamp("timePaidBasket") != null ? resultSet.getTimestamp("timePaidBasket").toLocalDateTime() : null);
                    basket.setTimeCancelledBasket(resultSet.getTimestamp("timeCancelledBasket") != null ? resultSet.getTimestamp("timeCancelledBasket").toLocalDateTime() : null);
                    basket.setBasketOpen(resultSet.getBoolean("isBasketOpen"));
                    basket.setBasketPaid(resultSet.getBoolean("isBasketPaid"));
                    basket.setBasketCancelled(resultSet.getBoolean("isBasketCancelled"));
                    basket.setBasketOwnerId(resultSet.getLong("basketOwnerId"));
                    return basket;
                }
            }
        }
        return null;
    }

    public void updateBasket(Basket basket) throws SQLException {
        String sql = "UPDATE Basket SET timeOpenBasket = ?, timeCloseBasket = ?, timePaidBasket = ?, timeCancelledBasket = ?, isBasketOpen = ?, isBasketPaid = ?, isBasketCancelled = ?, basketOwnerId = ? WHERE basketNr = ?";
        try (Connection conn = DatabaseConnectionPool.getDataSource().getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            NullerCheckerTimeStamp(basket, statement);
            if (basket.getBasketOwnerId() != null) {
                statement.setLong(8, basket.getBasketOwnerId());
            } else {
                statement.setNull(8, java.sql.Types.BIGINT);
            }
            statement.setLong(9, basket.getBasketNr());

            statement.executeUpdate();
        }
    }

    private void NullerCheckerTimeStamp(Basket basket, PreparedStatement statement) throws SQLException {
        statement.setTimestamp(1, basket.getTimeOpenBasket() != null ? java.sql.Timestamp.valueOf(basket.getTimeOpenBasket()) : null);
        statement.setTimestamp(2, basket.getTimeCloseBasket() != null ? java.sql.Timestamp.valueOf(basket.getTimeCloseBasket()) : null);
        statement.setTimestamp(3, basket.getTimePaidBasket() != null ? java.sql.Timestamp.valueOf(basket.getTimePaidBasket()) : null);
        statement.setTimestamp(4, basket.getTimeCancelledBasket() != null ? java.sql.Timestamp.valueOf(basket.getTimeCancelledBasket()) : null);
        statement.setBoolean(5, basket.isBasketOpen());
        statement.setBoolean(6, basket.isBasketPaid());
        statement.setBoolean(7, basket.isBasketCancelled());
    }

}
