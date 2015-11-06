package test.maven;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Alexey on 06.11.2015.
 */
public class Add extends Base {


    public Add() throws ClassNotFoundException, SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("title", "Add box");
        request.setAttribute("page", "add");

        request.getRequestDispatcher("add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("width") != null && request.getParameter("height") != null && request.getParameter("depth") != null) {
            String description = request.getParameter("description");
            Integer width = Integer.parseInt(request.getParameter("width"));
            Integer height = Integer.parseInt(request.getParameter("height"));
            Integer depth = Integer.parseInt(request.getParameter("depth"));

            if (width <= 0 || height <= 0 || depth <= 0) {
                response.sendRedirect("/add?msg=wronginput");

            } else {
                String sql = "INSERT INTO boxes VALUES(NULL, '"+description+"', "+width+", "+height+", "+depth+")";
                try {
                    this.doSqlUpdate(sql);
                    response.sendRedirect("/");
                } catch (SQLException e) {
                    response.sendRedirect("/add?msg=error");
                    e.printStackTrace();
                }
            }
        } else {
            response.sendRedirect("/add?msg=notenoughtparams");
        }
    }
}
