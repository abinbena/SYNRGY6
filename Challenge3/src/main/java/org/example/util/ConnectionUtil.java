package org.example.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionUtil {
    private static HikariDataSource dataSource;

    static {
        HikariConfig config= new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/Challenge3");
        config.setUsername("root");
        config.setPassword("");

        config.setMaximumPoolSize(5);
        config.setMinimumIdle(1);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10 * 60_000);

        dataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getDataSource(){
        return dataSource;
    }
}
