package ua.dpw.database;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.flywaydb.core.Flyway;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Migrate {

    public static void migrate(String url) {
        Flyway flyway = Flyway
            .configure()
            .dataSource(url, "", "")
            .loggers("slf4j")
            .load();
        flyway.migrate();
    }
}
