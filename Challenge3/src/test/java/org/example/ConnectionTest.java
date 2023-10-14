package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.example.util.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {
    @Test
    void testConnectionPool(){
        HikariConfig config= new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/Challenge3");
        config.setUsername("root");
        config.setPassword("");

        config.setMaximumPoolSize(5);
        config.setMinimumIdle(1);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10 * 60_000);

        try{
            HikariDataSource dataSource = new HikariDataSource(config);
            Connection connection = dataSource.getConnection();
            connection.close();
            dataSource.close();
        }catch (SQLException e){
            Assertions.fail(e);
        }
    }
    @Test
    void testConnection() throws SQLException{
        Connection connection = ConnectionUtil.getDataSource().getConnection();
    }

}
