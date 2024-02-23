package Servlet;

import org.example.JspUppgift.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(urlPatterns = "/showCourse")
public class ShowCourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //uses a query to bring all courses and shows it in a table
        LinkedList data = MysqlConnector.getConnector().selectQuery("allFromkurser");
        Userbean usersBean = new Userbean();
        usersBean.setData(data);

        req.getSession().setAttribute("usersBean", usersBean);
        req.getRequestDispatcher("/jsp/courses.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Userbean userBean = (Userbean) req.getSession().getAttribute("usersBean");

        if(userBean.getUserType() == USER_TYPE.teacher && userBean.getprivilageType() == PRIVILAGE_TYPE.user && userBean.getStateType() == STATE_TYPE.confirmed){
            LinkedList<String[]> searchStudent = null;
            LinkedList<String[]> dataOfSearch = MysqlConnector.getConnector().selectQuery("allFromkurser",((Userbean) req.getSession().getAttribute("usersBean")).getId());

            if(req.getParameter("teacherSubmitCourse")!=null){
                searchStudent  = MysqlConnector.getConnector().selectQuery("searchAStudent",req.getParameter("showCourse"));
            }else {
                searchStudent = dataOfSearch;
            }
            

            req.setAttribute("searchAStudent", searchStudent);
            req.setAttribute("dataOfSearch", dataOfSearch);
            req.getRequestDispatcher("/jsp/showcourse.jsp").forward(req, resp);
        }
        else {
            req.getRequestDispatcher("/jsp/showcourse.jsp").forward(req, resp);
        }
    }
}
