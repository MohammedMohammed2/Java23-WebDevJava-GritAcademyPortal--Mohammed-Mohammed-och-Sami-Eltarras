package Servlet;

import org.example.JspUppgift.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "CoursesServlet", urlPatterns = "/courses")
public class CoursesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //uses a query to bring all courses and shows it in a table
        LinkedList data = MysqlConnector.getConnector().selectQuery("allFromkurser");
        Userbean userbean =new Userbean();

        userbean.setData(data);

        req.getSession().setAttribute("userbean", userbean);
        req.getRequestDispatcher("/jsp/courses.jsp").forward(req, resp);
    }
}

