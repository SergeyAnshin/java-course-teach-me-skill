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

@WebServlet(urlPatterns = "/registration", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private final UserService<User> userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(User.LOGIN_PARAM);
        String password = req.getParameter(User.PASSWORD_PARAM);
        User user = new User(login, password);
        if (userService.findByLogin(user.getLogin()) == null) {
            if (userService.save(user)) {
                resp.getWriter().write(SUCCESSFUL_REGISTRATION_MESSAGE.getMessage());
                req.getSession().removeAttribute(User.SESSION_ATTRIBUTE);
            } else {
                resp.getWriter().write(FAILED_REGISTRATION_MESSAGE.getMessage());
            }
        } else {
            resp.getWriter().write("User " + FAILED_EXISTS_MESSAGE.getMessage());
        }
    }
}
