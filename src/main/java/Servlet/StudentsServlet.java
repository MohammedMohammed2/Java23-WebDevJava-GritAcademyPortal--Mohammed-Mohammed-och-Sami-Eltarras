package Servlet;

import org.example.JspUppgift.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name="showStudent", urlPatterns = "/showStudents")
public class StudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //makes sure that if the user is already logged in they cant log in again , instead it will show their user page
        if (req.getSession().getAttribute("stateType") == STATE_TYPE.anonymous){
            req.getRequestDispatcher("jsp/login.jsp").forward(req,resp);
        }
        else {
            doPost(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Userbean userBean = (Userbean) req.getSession().getAttribute("userBean");

        if (userBean==null){

            req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);

        }

       else if(userBean.getUserType() == USER_TYPE.teacher && userBean.getprivilageType() == PRIVILAGE_TYPE.user && userBean.getStateType() == STATE_TYPE.confirmed){

            LinkedList data = MysqlConnector.getConnector().selectQuery("allFromstudenter");
            userBean.setData(data);
            req.getSession().setAttribute("usersBean", userBean);System.out.println(((Userbean)(req.getSession().getAttribute("usersBean"))).getData());
            req.getRequestDispatcher("/jsp/students.jsp").forward(req, resp);
        }

        else if(userBean.getUserType() == USER_TYPE.student && userBean.getprivilageType() == PRIVILAGE_TYPE.user && userBean.getStateType() == STATE_TYPE.confirmed){
            req.getRequestDispatcher("/jsp/Fragments/badBoys/naughtyBoy.jsp").forward(req, resp);
        }
    }
}

