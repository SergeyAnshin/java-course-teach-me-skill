package org.anshin.web.servlet.admin;

import org.anshin.service.UserService;
import org.anshin.service.impl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.anshin.web.servlet.ServletConstants.*;

@WebServlet(urlPatterns = URL_ALL_USERS_SERVLET, name = NAME_ALL_USERS_SERVLET)
public class AllUsersServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserServiceImpl) config.getServletContext().getAttribute(ATTRIBUTE_USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(ATTRIBUTE_USERS, userService.findAll());
        req.getServletContext().getRequestDispatcher(PATH_USERS_JSP).forward(req, resp);
    }
}
