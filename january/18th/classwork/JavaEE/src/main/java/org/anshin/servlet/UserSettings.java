package org.anshin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.anshin.servlet.ServletConstant.*;

@WebServlet(urlPatterns = URL_USER_SETTINGS_SERVLET, name = NAME_USER_SETTINGS)
public class UserSettings extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(PATH_USER_SETTINGS_JSP).forward(req, resp);
    }
}
