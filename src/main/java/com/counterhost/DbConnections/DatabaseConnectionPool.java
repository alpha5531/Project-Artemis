package com.counterhost.DbConnections;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

import static com.counterhost.Dictionaries.PropertiesDictionary.properties;

public class DatabaseConnectionPool {

    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(properties.getAdresBazyDanych());
        config.setUsername(properties.getLoginBazyDanych());
        config.setPassword(properties.getHasloBazyDanych());
        config.setMaximumPoolSize(properties.getPulaPolaczenMax());
        config.setMinimumIdle(properties.getPulaPolaczenMin());
        config.setMaxLifetime(properties.getCzasZyciaPolaczenia());
        config.setConnectionTimeout(properties.getCzasOczekiwaniaNaPolaczenie());
        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}

