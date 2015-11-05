package test.maven;

import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alexey on 05.11.2015.
 */
public class Base extends HttpServlet {

    protected Connection connection;

    public Base() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost/java_db","java_db_user","123456");
    }

    public ResultSet doSqlQuery(String sql) throws SQLException {
        return this.connection.createStatement().executeQuery(sql);
    }

    public void doSqlUpdate(String sql) throws SQLException {
        this.connection.createStatement().executeUpdate(sql);
    }
}
