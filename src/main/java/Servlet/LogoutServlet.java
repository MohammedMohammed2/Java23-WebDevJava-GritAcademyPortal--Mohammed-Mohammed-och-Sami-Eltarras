package Servlet;

import org.example.JspUppgift.models.STATE_TYPE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //to log the user out by invalidating the session and setting the state type to anonymous thus the user is no loger logged in
        req.getSession().invalidate();
        getServletContext().setAttribute("stateType", STATE_TYPE.anonymous);
        resp.sendRedirect("/login");
    }
}
