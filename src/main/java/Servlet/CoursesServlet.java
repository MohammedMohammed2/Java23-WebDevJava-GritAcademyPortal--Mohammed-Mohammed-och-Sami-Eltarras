package Servlet;

import org.example.JspUppgift.models.MysqlConnector;
import org.example.JspUppgift.models.Userbean;

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
        Userbean usersBean = new Userbean();
        usersBean.setData(data);

        req.getSession().setAttribute("usersBean", usersBean);
        System.out.println(((Userbean)(req.getSession().getAttribute("usersBean"))).getData());
        req.getRequestDispatcher("/jsp/courses.jsp").forward(req, resp);
    }
}

