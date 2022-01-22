package org.anshin.servlets;

import org.anshin.entities.User;
import org.anshin.services.UserService;
import org.anshin.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.anshin.enums.ServiceMessage.*;

@WebServlet(urlPatterns = "/auth", name = "AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
    private final UserService<User> userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(User.LOGIN_PARAM);
        String password = req.getParameter(User.PASSWORD_PARAM);
        User user = userService.findByLoginAndPassword(login, password);
        if (user != null) {
            user.setAuthorized(true);
            req.getSession().setAttribute(User.SESSION_ATTRIBUTE, user);
            resp.getWriter().write(SUCCESSFUL_AUTHENTICATION_MESSAGE.getMessage());
        } else {
            resp.getWriter().write(FAILED_AUTHENTICATION_MESSAGE.getMessage());
        }
    }
}
