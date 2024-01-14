package com.counterhost.DbConnections;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionPoolTest {

    @Test
    void getDataSource_ShouldReturnDataSource() {
        DataSource dataSource = DatabaseConnectionPool.getDataSource();
        assertNotNull(dataSource, "DataSource should not be null");
        assertTrue(dataSource instanceof HikariDataSource, "DataSource should be an instance of HikariDataSource");
    }
}
