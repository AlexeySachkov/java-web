package test.maven;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alexey on 05.11.2015.
 */
public class Single extends Base {

    public Single() throws ClassNotFoundException, SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") == null) {
            response.sendRedirect("/?msg=notfound");
        } else {
            request.setAttribute("title", "Single details");
            request.setAttribute("page", "single");

            try {
                ResultSet res = this.doSqlQuery("SELECT id, description, width, height, depth FROM boxes WHERE id = "+Integer.parseInt(request.getParameter("id")));
                Box box = new Box();
                if (res.next()) {
                    box.setId(res.getInt(1));
                    box.setDescription(res.getString(2));
                    box.setWidth(res.getInt(3));
                    box.setHeight(res.getInt(4));
                    box.setDepth(res.getInt(5));
                }
                request.setAttribute("box", box);
            } catch (SQLException e) {
                response.sendRedirect("/?msg=error");
                e.printStackTrace();
            }

            request.getRequestDispatcher("single.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") == null) {
            response.sendRedirect("/?msg=notfound");
        } else {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String description = request.getParameter("description");
            Integer width = Integer.parseInt(request.getParameter("width"));
            Integer height = Integer.parseInt(request.getParameter("height"));
            Integer depth = Integer.parseInt(request.getParameter("depth"));

            try {
                if (width <= 0 || height <= 0 || depth <= 0) {
                    throw new SQLException();
                }
                String sql = "UPDATE boxes SET description = '"+description+"', width = "+width+", height = "+height+", depth = "+depth+" WHERE id = "+id;
                this.doSqlUpdate(sql);
            } catch (SQLException e) {
                response.sendRedirect("/single?id="+id+"&msg=error");
                e.printStackTrace();
            }

            response.sendRedirect("/single?id="+id+"&msg=udpated");
        }
    }
}
