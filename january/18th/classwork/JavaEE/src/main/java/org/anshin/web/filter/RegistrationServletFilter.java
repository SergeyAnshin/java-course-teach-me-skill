package org.anshin.web.filter;

import org.anshin.service.UserService;
import org.anshin.service.impl.UserServiceImpl;
import org.anshin.validator.AbstractValidator;
import org.anshin.validator.UserValidator;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.anshin.web.servlet.ServletConstants.*;
import static org.anshin.validator.UserValidator.*;

@WebFilter(servletNames = {NAME_REGISTRATION_SERVLET})
public class RegistrationServletFilter extends HttpFilter {
    private final AbstractValidator userValidator = new UserValidator();
    private UserService userService;

    @Override
    public void init(FilterConfig config) throws ServletException {
        super.init(config);
        userService = (UserServiceImpl) config.getServletContext().getAttribute(ATTRIBUTE_USER_SERVICE);
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equalsIgnoreCase(METHOD_POST)) {
            String email = req.getParameter(PARAMETER_EMAIL);
            String login = req.getParameter(PARAMETER_LOGIN);
            String password = req.getParameter(PARAMETER_PASSWORD);
            if (userValidator.isValidValueForField(login, FIELD_NAME_LOGIN)
                    && userValidator.isValidValueForField(password, FIELD_NAME_PASSWORD)) {
                if (userService.exists(email, login)) {
                    req.setAttribute(ATTRIBUTE_WRONG_VALUE_MESSAGE, FAILED_MESSAGE_USER_EXISTS);
                    req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, res);
                } else {
                    chain.doFilter(req, res);
                }
            } else {
                req.setAttribute(ATTRIBUTE_WRONG_VALUE_MESSAGE, userValidator.getErrorMessage());
                req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, res);
            }
        } else {
            chain.doFilter(req, res);
        }
    }
}
