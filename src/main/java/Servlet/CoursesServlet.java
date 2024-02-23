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
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Userbean userBean = (Userbean) req.getSession().getAttribute("userBean");
        if (userBean==null){
            //uses a query to bring all courses and shows it in a table
            LinkedList data = MysqlConnector.getConnector().selectQuery("allFromkurser");

            userBean.setData(data);

            req.getSession().setAttribute("userbean", userBean);
            req.getRequestDispatcher("/jsp/courses.jsp").forward(req, resp);
        }

            else if (userBean.getUserType() == USER_TYPE.teacher && userBean.getprivilageType() == PRIVILAGE_TYPE.user && userBean.getStateType() == STATE_TYPE.confirmed) {

            LinkedList<String[]> searchCourse = null;
            LinkedList<String[]> dataOfSearchC = MysqlConnector.getConnector().selectQuery("allFromkurser", ((Userbean) req.getSession().getAttribute("userBean")).getId());


            if (req.getParameter("teacherSubmitButton") != null) {
                searchCourse = MysqlConnector.getConnector().selectQuery("allStudentInCourse", req.getParameter("courseName"));
            } else {
                searchCourse = dataOfSearchC;
            }
            req.setAttribute("searchACourse", searchCourse);
            req.setAttribute("dataOfSearch", dataOfSearchC);
            req.getRequestDispatcher("/jsp/courses.jsp").forward(req, resp);
        }
    }
}

