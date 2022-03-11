package org.anshin.web.servlet.admin;

import org.anshin.entity.User;
import org.anshin.valuelisthandler.EntityListHandler;
import org.anshin.valuelisthandler.EntityListIterator;
import org.anshin.dao.UserDAO;
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
        EntityListIterator<User> userEntityListIterator =
                (EntityListHandler<User, UserDAO>) req.getSession().getAttribute(ATTRIBUTE_USER_VALUE_LIST_ITERATOR);

        if (req.getParameter(PARAMETER_PAGE) == null) {
            req.setAttribute(ATTRIBUTE_USERS, userEntityListIterator.getNextEntities(2));
        } else if (req.getParameter(PARAMETER_PAGE).equals("next")) {
            req.setAttribute(ATTRIBUTE_USERS, userEntityListIterator.getNextEntities(2));
        } else {
            req.setAttribute(ATTRIBUTE_USERS, userEntityListIterator.getPreviousEntities(2));
        }

        req.getServletContext().getRequestDispatcher(PATH_USERS_JSP).forward(req, resp);
    }
}
