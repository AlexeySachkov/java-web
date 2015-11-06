package test.maven;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexey on 05.11.2015.
 */
public class Index extends Base {

    public Index() throws ClassNotFoundException, SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Main page");
        request.setAttribute("page", "index");

        try {
            ResultSet res = this.doSqlQuery("SELECT COUNT(id) FROM boxes");
            res.next();
            request.setAttribute("boxCount", res.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sql = "SELECT id, width, height, depth FROM boxes";

            if (request.getParameter("depthFilter") != null && request.getParameter("depthFilterMin") != null) {
                Integer depthFilterMin = Integer.parseInt(request.getParameter("depthFilterMin"));

                sql = sql.concat(" WHERE depth >= "+depthFilterMin);
            }


            Integer limit = 10;
            if (request.getParameter("limit") != null) {
                limit = Integer.parseInt(request.getParameter("limit"));
            }
            if (limit > 0) {
                sql = sql.concat(" LIMIT "+limit);
            }
            ResultSet res = this.doSqlQuery(sql);
            ArrayList<Box> boxes = new ArrayList<Box>();
            while (res.next()) {
                boxes.add(new Box(res.getInt(1), null, res.getInt(2), res.getInt(3), res.getInt(4)));
            }

            request.setAttribute("boxes", boxes);
            request.setAttribute("boxesNum", limit);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("index_.jsp").forward(request, response);
    }
}
