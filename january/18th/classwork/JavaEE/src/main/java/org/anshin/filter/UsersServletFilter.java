package org.anshin.filter;

import org.anshin.entity.User;
import org.anshin.enums.Role;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.anshin.servlet.ServletConstant.*;

@WebFilter(servletNames = NAME_ALL_USERS_SERVLET)
public class UsersServletFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute(ATTRIBUTE_SESSION_AUTH_USER) != null) {
            User user = (User) session.getAttribute(ATTRIBUTE_SESSION_AUTH_USER);
            if (user.getRole().equals(Role.ADMIN)) {
                chain.doFilter(req, res);
            } else {
                res.sendRedirect(URL_HOME_SERVLET);
            }
        } else {
            res.sendRedirect(URL_AUTHENTICATION_SERVLET);
        }

    }
}
