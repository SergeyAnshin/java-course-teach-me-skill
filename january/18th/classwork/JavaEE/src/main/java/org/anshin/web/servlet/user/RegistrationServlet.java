package org.anshin.web.servlet.user;

import org.anshin.entity.User;
import org.anshin.service.UserService;
import org.anshin.service.impl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.anshin.enums.Role.USER;
import static org.anshin.web.servlet.ServletConstants.*;

@WebServlet(urlPatterns = URL_REGISTRATION_SERVLET, name = NAME_REGISTRATION_SERVLET)
public class RegistrationServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserServiceImpl) config.getServletContext().getAttribute(ATTRIBUTE_USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter(PARAMETER_EMAIL);
        String login = req.getParameter(PARAMETER_LOGIN);
        String password = req.getParameter(PARAMETER_PASSWORD);
        User user = new User(email, login, password, USER);

        if (userService.save(user)) {
            if (req.getSession().getAttribute(ATTRIBUTE_SESSION_AUTH_USER) != null) {
                req.getSession().invalidate();
            }
            resp.sendRedirect(URL_AUTHENTICATION_SERVLET);
        } else {
            req.setAttribute(ATTRIBUTE_REGISTRATION_RESULT, FAILED_MESSAGE_USER_EXISTS);
            req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
        }

    }
}
