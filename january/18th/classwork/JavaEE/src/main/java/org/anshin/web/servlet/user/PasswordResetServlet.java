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

import static org.anshin.web.servlet.ServletConstants.*;

@WebServlet(urlPatterns = URL_PASSWORD_RESET_SERVLET, name = NAME_PASSWORD_RESET_SERVLET)
public class PasswordResetServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserServiceImpl) config.getServletContext().getAttribute(ATTRIBUTE_USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute(ATTRIBUTE_USER_IS_VERIFY, false);
        req.getServletContext().getRequestDispatcher(PATH_PASSWORD_RESET_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ((Boolean) req.getSession().getAttribute(ATTRIBUTE_USER_IS_VERIFY)) {
            String newPassword = req.getParameter(PARAMETER_PASSWORD);
            String email = (String) req.getSession().getAttribute(ATTRIBUTE_EMAIL);
            if (userService.updatePasswordForUserWithEmail(newPassword, email)) {
                req.getSession().removeAttribute(ATTRIBUTE_USER_IS_VERIFY);
                resp.sendRedirect(URL_AUTHENTICATION_SERVLET);
            } else {
                req.getServletContext().getRequestDispatcher(PATH_PASSWORD_RESET_JSP).forward(req, resp);
            }
        } else {
            String email = req.getParameter(PARAMETER_EMAIL);
            String keyword = req.getParameter(PARAMETER_KEYWORD);
            if (userService.existsByEmailAndKeyword(email, keyword)) {
                req.getSession().setAttribute(ATTRIBUTE_USER_IS_VERIFY, true);
                req.getSession().setAttribute(ATTRIBUTE_EMAIL, email);
            } else {
                req.setAttribute(ATTRIBUTE_WRONG_VALUE_MESSAGE, FAILED_MESSAGE_PASSWORD_RESET);
            }
            req.getServletContext().getRequestDispatcher(PATH_PASSWORD_RESET_JSP).forward(req, resp);
        }
    }
}
