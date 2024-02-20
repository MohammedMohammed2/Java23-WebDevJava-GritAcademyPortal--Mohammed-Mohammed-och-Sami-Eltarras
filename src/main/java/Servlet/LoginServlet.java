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

        req.getSession().setAttribute("errorMessage","");
        req.getRequestDispatcher("/jsp/login.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String userType = req.getParameter("user_type");


        if (userType.equals("student")) {

            LinkedList<String[]> data = MysqlConnector.getConnector().selectQuery("login", username, password);


            if (data.size() > 1) {

                Userbean userBean = new Userbean((data.get(1))[0], USER_TYPE.student, PRIVILAGE_TYPE.user, STATE_TYPE.confirmed);

                req.getSession().setAttribute("userBean", userBean);
                req.getRequestDispatcher("/userpage").forward(req, resp);
            } else {


                req.getSession().setAttribute("errorMessage", "Student not found");
                req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);

            }

        } else if (userType.equals("teacher")) {

            LinkedList<String[]> data = MysqlConnector.getConnector().selectQuery("llogin", username, password);

            if (data.size() > 1) {

                Userbean userBean = new Userbean((data.get(1))[0], USER_TYPE.teacher, resolvePrivilageType(data.get(1)[8]), STATE_TYPE.confirmed);
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
    private PRIVILAGE_TYPE resolvePrivilageType (String privilageType){
        if (privilageType.equals("user")) {
            return PRIVILAGE_TYPE.user;
        } else if (privilageType.equals("admin")) {
            return PRIVILAGE_TYPE.admin;
        } else {
            return null;
        }
    }
}
