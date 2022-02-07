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
import java.util.Optional;

import static org.anshin.web.servlet.ServletConstants.*;

@WebServlet(urlPatterns = URL_AUTHENTICATION_SERVLET, name = NAME_AUTHENTICATION_SERVLET)
public class AuthenticationServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserServiceImpl) config.getServletContext().getAttribute(ATTRIBUTE_USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(PATH_AUTHENTICATION_JSP).forward(req, resp);
        req.removeAttribute(ATTRIBUTE_REGISTRATION_RESULT);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(PARAMETER_LOGIN);
        String password = req.getParameter(PARAMETER_PASSWORD);

        Optional<User> user = userService.findByLoginAndPassword(login, password);
        if (user.isPresent()) {
            user.get().setAuthorized(true);
            req.getSession().setAttribute(ATTRIBUTE_SESSION_AUTH_USER, user.get());
            resp.sendRedirect(URL_HOME_SERVLET);
        } else {
            req.setAttribute(ATTRIBUTE_AUTHENTICATION_FAILED_MESSAGE, FAILED_MESSAGE_AUTHENTICATION);
            req.getServletContext().getRequestDispatcher(PATH_AUTHENTICATION_JSP).forward(req, resp);
        }
    }
}
