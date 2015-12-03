package test.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alexey on 03.12.2015.
 */
public class Database {

    private static Database instance = new Database();

    private Connection connection = null;

    private Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/java_db","java_db_user","123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        return Database.instance;
    }

    public ResultSet doSqlQuery(String sql) throws Exception {
        if (this.connection != null) {
            return this.connection.createStatement().executeQuery(sql);
        } else {
            throw new Exception("Failed to connect to database!");
        }
    }

    public int doSqlUpdate(String sql) throws Exception {
        if (this.connection != null) {
            return this.connection.createStatement().executeUpdate(sql);
        } else {
            throw new Exception("Failed to connect to database!");
        }
    }
}
