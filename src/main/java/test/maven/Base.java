package test.maven;

import javax.servlet.http.HttpServlet;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alexey on 05.11.2015.
 */
public class Base extends HttpServlet {

    protected Database databaseConnection;

    public Base() throws ClassNotFoundException, SQLException {
        this.databaseConnection = Database.getInstance();
    }

    public ResultSet doSqlQuery(String sql) throws Exception {
        return this.databaseConnection.doSqlQuery(sql);
    }

    public int doSqlUpdate(String sql) throws Exception {
        return this.databaseConnection.doSqlUpdate(sql);
    }
}
