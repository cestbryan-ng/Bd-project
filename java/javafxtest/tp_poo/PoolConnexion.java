package javafxtest.tp_poo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnexion {
    private HikariDataSource dataSource;

    public PoolConnexion() {
        try {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:mysql://localhost:3306/tp_poo");
            config.setUsername("Jean_Roland");
            config.setPassword("Papasenegal0");
            config.setMaximumPoolSize(10);
            this.dataSource = new HikariDataSource(config);
        } catch (Exception e) {
            System.out.println("Pas possible " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

    public void close() {
        this.dataSource.close();
    }
}
