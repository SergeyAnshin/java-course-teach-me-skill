package org.anshin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.anshin.servlet.ServletConstant.*;


@WebServlet(urlPatterns = URL_LOGOUT_SERVLET, name = NAME_LOGOUT_SERVLET)
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute(ATTRIBUTE_SESSION_AUTH_USER );
        resp.getWriter().write(SUCCESSFUL_MESSAGE_LOGOUT);
    }


}
