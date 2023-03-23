package ua.dpw.database;

import java.sql.Connection;
import java.sql.SQLException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;
import ua.dpw.AppLauncher;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Database {

    private static final Logger LOG = LogManager.getLogger(Database.class);
    private static BasicDataSource dataSource = null;

    static {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl(
            "jdbc:h2:" + AppLauncher.APPLICATION_PROPERTIES.BASE_PATH + "currency_bot_db");
        dataSource.setUsername("");
        dataSource.setPassword("");

        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxTotal(25);

        migrate();
    }

    public static void setDataSource(BasicDataSource dataSource) {
        Database.dataSource = dataSource;
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            LOG.warn("Error get connection: {}", e);
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void migrate() {
        Flyway flyway = Flyway
            .configure()
            .dataSource(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword())
            .load();
        flyway.migrate();
    }
}
