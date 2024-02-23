package Servlet;

import org.example.JspUppgift.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //makes sure that if the user is already logged in they cant log in again , instead it will show their user page
        if (req.getSession().getAttribute("stateType") == STATE_TYPE.anonymous){
            req.getRequestDispatcher("jsp/login.jsp").forward(req,resp);}
        else{
            req.getRequestDispatcher("/userpage").forward(req, resp);
            req.getSession().setAttribute("errorMessage","");}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        //variables for username and password to login
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String userType = req.getParameter("user_type");


        //if the user selects student
        if (userType.equals("student")) {


            //puts the username and password in a quary to see if they entered the right info
            LinkedList<String[]> data = MysqlConnector.getConnector().selectQuery("login", username, password);

            //if the username and password are vaild then they will log in successfully
            if (data.size() > 1) {

                Userbean userBean = new Userbean((data.get(1))[0], USER_TYPE.student, PRIVILAGE_TYPE.user, STATE_TYPE.confirmed);

                req.getSession().setAttribute("userBean", userBean);
                req.getRequestDispatcher("/userpage").forward(req, resp);

            }
            //if the username and password is wrong then this will display an error message
            else {


                req.getSession().setAttribute("errorMessage", "Student not found");
                req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);

            }

        } else if (userType.equals("teacher")) {

            LinkedList<String[]> data = MysqlConnector.getConnector().selectQuery("llogin", username, password);

            if (data.size() > 1) {

                Userbean userBean = new Userbean((data.get(1))[0], USER_TYPE.teacher, PRIVILAGE_TYPE.user , STATE_TYPE.confirmed);
                req.getSession().setAttribute("userBean", userBean);
                req.getRequestDispatcher("/userpage").forward(req, resp);
            }
            else{

                req.getSession().setAttribute("errorMessage", "Teacher not found");
                req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);

            }
        }
        else {
            req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
        }
    }
}
