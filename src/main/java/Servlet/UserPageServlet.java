package Servlet;

import org.example.JspUppgift.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "UserPageServlet", urlPatterns = "/userpage")
public class UserPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Userbean userBean = (Userbean) req.getSession().getAttribute("userBean");


        if (userBean==null){
            req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
        }

        else if (userBean.getUserType() == USER_TYPE.student && userBean.getStateType() == STATE_TYPE.confirmed) {
            LinkedList<String[]> data = MysqlConnector.getConnector().selectQuery("allStudentInCoursesAndTeachers", ((Userbean) req.getSession().getAttribute("userBean")).getId());


            req.setAttribute("data", data);
            req.getSession().setMaxInactiveInterval(360);
            req.getRequestDispatcher("jsp/userpage.jsp").forward(req, resp);

        }

        else if(userBean.getUserType() == USER_TYPE.teacher && userBean.getprivilageType() == PRIVILAGE_TYPE.user && userBean.getStateType() == STATE_TYPE.confirmed) {

            LinkedList<String[]> data = MysqlConnector.getConnector().selectQuery("allStudentInCourse", ((Userbean) req.getSession().getAttribute("userBean")).getId());

            req.setAttribute("data", data);
            req.getRequestDispatcher("jsp/userpage.jsp").forward(req, resp);

        }


        else if(userBean.getUserType()== USER_TYPE.teacher && userBean.getprivilageType()== PRIVILAGE_TYPE.admin && userBean.getStateType() == STATE_TYPE.confirmed) {

            LinkedList<String[]> data = MysqlConnector.getConnector().selectQuery("adminteacherpage", ((Userbean) req.getSession().getAttribute("userBean")).getId());

            req.setAttribute("data", data);
            req.getRequestDispatcher("jsp/userpage.jsp").forward(req, resp);

        }
    }
}

