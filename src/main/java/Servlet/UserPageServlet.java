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

        //if userbean is null it will send the user back to log in
        if (userBean==null){
            req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
        }
        //gets the user type and sets state type to conformed
        else if (userBean.getUserType() == USER_TYPE.student && userBean.getprivilageType() == PRIVILAGE_TYPE.user && userBean.getStateType() == STATE_TYPE.confirmed) {
            //quary to get all the students in courses and the teachers
            LinkedList<String[]> AllStudentsInCourse = MysqlConnector.getConnector().selectQuery("allStudentInCoursesAndTeachers", ((Userbean) req.getSession().getAttribute("userBean")).getId());
            LinkedList<String[]> data = null;

            //checks the studentsubmitbutton and if its not null thne it will start a quary that brings all the the students in a specifc course
            if(req.getParameter("studentSubmitButton")!=null){
                data = MysqlConnector.getConnector().selectQuery("allStudentInCourse",req.getParameter("courseId"));
            } else {
                data = AllStudentsInCourse;
            }

            req.setAttribute("data", data);
            req.setAttribute("AllStudentsInCourse",AllStudentsInCourse);
            req.getSession().setMaxInactiveInterval(360);
            req.getRequestDispatcher("jsp/userpage.jsp").forward(req, resp);

        } else if(userBean.getUserType() == USER_TYPE.teacher && userBean.getprivilageType() == PRIVILAGE_TYPE.user && userBean.getStateType() == STATE_TYPE.confirmed) {
            LinkedList<String[]> data = MysqlConnector.getConnector().selectQuery("allStudentInCourseForTeacher", ((Userbean) req.getSession().getAttribute("userBean")).getId());

            req.setAttribute("data", data);
            req.getRequestDispatcher("jsp/userpage.jsp").forward(req, resp);
        }
    }
}

