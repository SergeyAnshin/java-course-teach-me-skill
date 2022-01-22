package org.anshin.filters;

import org.anshin.validators.AbstractValidator;
import org.anshin.validators.UserValidator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"RegistrationServlet", "AuthenticationServlet"})
public class RegistrationServletFilter extends HttpFilter {
    private final AbstractValidator validator = new UserValidator();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (validator.isValidValueForField(login,"login")
                && validator.isValidValueForField(password,"password")) {
            chain.doFilter(req, res);
        } else {
            res.getWriter().write(validator.getErrorMessage());
        }
    }
}
