package org.anshin.sergey.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.anshin.sergey.servlet.ServletConstant.*;

@WebServlet(urlPatterns = URL_HOME,name = NAME_HOME_SERVLET)
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(PATH_HOME_JSP).forward(req, resp);
    }
}
