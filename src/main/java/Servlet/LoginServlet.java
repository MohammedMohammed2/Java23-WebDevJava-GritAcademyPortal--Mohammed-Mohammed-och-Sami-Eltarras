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
        //retrieving data from loginForm
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String userType = req.getParameter("user_type");


        //comparing data with DB student or teacher
        if (userType.equals("student")) {
            LinkedList<String[]> data = MysqlConnector.getConnector().selectQuery("login", username, password);
            //data object always returns row with column names
            if (data.size() > 1) {
                req.getSession().setMaxInactiveInterval(360);
                Userbean userBean = new Userbean((data.get(1))[0], USER_TYPE.student, PRIVILAGE_TYPE.user, STATE_TYPE.confirmed);
                req.getSession().setAttribute("userBean", userBean);
                req.getRequestDispatcher("/userpage").forward(req,resp);
            }else{//if login not found goes back to login form and sows a message
                req.getSession().setAttribute("errorMessage","Student not found");
                req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
            }
        }else if (userType.equals("teacher")) {
            List data = MysqlConnector.getConnector().selectQuery("Llogin", username, password);
            //data object always returns row with column names
            if (data.size() > 1) {
                resp.getWriter().print("LOGGED IN - ");
            }else{
                req.getRequestDispatcher("JSP/login.jsp").forward(req,resp);
            }
        }
    }
}
