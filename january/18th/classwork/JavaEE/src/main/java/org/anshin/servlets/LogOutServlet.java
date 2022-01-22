package org.anshin.servlets;

import org.anshin.entities.User;
import org.anshin.enums.ServiceMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout", name = "LogOutServlet")
public class LogOutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute(User.SESSION_ATTRIBUTE);
        resp.getWriter().write(ServiceMessage.SUCCESSFUL_LOG_OUT_MESSAGE.getMessage());
    }
}
