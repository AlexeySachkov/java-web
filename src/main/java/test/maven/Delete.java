package test.maven;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alexey on 06.11.2015.
 */
public class Delete extends Base {
    public Delete() throws ClassNotFoundException, SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("title", "Delete box");
            request.setAttribute("page", "delete");

            try {
                ResultSet res = this.doSqlQuery("SELECT id, description, depth, width, height FROM boxes WHERE id = "+id);
                res.next();
                Box box = new Box(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4), res.getInt(5));
                request.setAttribute("box", box);
            } catch (SQLException e) {
                response.sendRedirect("/?msg=error");
                e.printStackTrace();
            }

            request.getRequestDispatcher("delete.jsp").forward(request, response);
        } else {
            response.sendRedirect("/single?msg=notfound");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            try {
                this.doSqlUpdate("DELETE FROM boxes WHERE id = "+id);
            } catch (SQLException e) {
                response.sendRedirect("/single?id="+id+"&msg=error");
                e.printStackTrace();
            }

            response.sendRedirect("/?msg=deleted");
        } else {
            response.sendRedirect("/single?msg=notfound");
        }
    }
}
