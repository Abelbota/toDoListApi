package org.fasttrackit.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConfigurations {

    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

        Properties properties = new Properties();

//        try-with-resources
        try (InputStream inputStream =
                     DatabaseConfigurations.class
                             .getClassLoader()
                             .getResourceAsStream("db.properties")) {


            properties.load(inputStream);

//        LOAD DRIVER CLASS

            Class.forName(properties.getProperty("DB_DRIVER_CLASS"));

            return DriverManager.getConnection(
                    properties.getProperty("DB_URL"),
                    properties.getProperty("DB_USERNAME"),
                    properties.getProperty("DB_PASSWORD"));
        }
    }
}
