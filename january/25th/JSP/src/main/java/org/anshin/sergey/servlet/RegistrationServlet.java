package org.anshin.sergey.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.anshin.sergey.servlet.ServletConstant.*;

@WebServlet(urlPatterns = URL_REGISTRATION, name = NAME_REGISTRATION_SERVLET)
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(PARAMETER_LOGIN);
        String password = req.getParameter(PARAMETER_PASSWORD);
        if (login.equals("admin")) {
            req.setAttribute("invalidLogin", "Login must not be like that!");
            req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
        } else {
            System.out.println(login + " " + password);
            resp.sendRedirect(URL_HOME);
        }
    }
}
