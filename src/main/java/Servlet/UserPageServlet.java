package Servlet;

import org.example.JspUppgift.models.MysqlConnector;
import org.example.JspUppgift.models.PRIVILAGE_TYPE;
import org.example.JspUppgift.models.USER_TYPE;
import org.example.JspUppgift.models.Userbean;

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
        req.getRequestDispatcher("/jsp/userpage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Userbean userBean = (Userbean) req.getSession().getAttribute("userBean");


        if (userBean.getUserType() == USER_TYPE.student) {
            LinkedList<String[]> data = MysqlConnector.getConnector().selectQuery("userpageinfo", ((Userbean) req.getSession().getAttribute("userBean")).getId());
            req.setAttribute("data", data);
            req.getRequestDispatcher("jsp/userpage.jsp").forward(req, resp);
        }
        else if(userBean.getUserType() == USER_TYPE.teacher && userBean.getprivilageType() == PRIVILAGE_TYPE.user) {
            LinkedList<String[]> data = MysqlConnector.getConnector().selectQuery("userteacherpage", ((Userbean) req.getSession().getAttribute("userBean")).getId());
            req.setAttribute("data", data);
            req.getRequestDispatcher("jsp/userpage.jsp").forward(req, resp);
        }
        else if(userBean.getUserType()== USER_TYPE.teacher && userBean.getprivilageType()== PRIVILAGE_TYPE.admin) {
            LinkedList<String[]> data = MysqlConnector.getConnector().selectQuery("adminteacherpage", ((Userbean) req.getSession().getAttribute("userBean")).getId());
            req.setAttribute("data", data);
            req.getRequestDispatcher("jsp/userpage.jsp").forward(req, resp);
        }
    }
}

