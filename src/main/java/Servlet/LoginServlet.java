package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {
    String getmethodattribute =(String)getServletContext().getAttribute("wtf" + "<br>");
    String servletinitattribute = getServletContext().getInitParameter("wtf2.0" + "<br>");
    //HttpServletRequest.getSession();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/HTML");
      resp.getWriter().print(req.getSession().getAttribute("MyName"));
     // HttpServletResponse.setCookie(new Cookie(String name, Object value));

    }
}
