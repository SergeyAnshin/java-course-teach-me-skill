package org.anshin.web.filter;

import org.anshin.entity.User;
import org.anshin.enums.Role;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.anshin.web.servlet.ServletConstants.*;

@WebFilter(servletNames = {NAME_ALL_USERS_SERVLET, NAME_DELETE_USER_SERVLET})
public class RoleFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute(ATTRIBUTE_SESSION_AUTH_USER);
        if (user != null && user.getRole().equals(Role.ADMIN)) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(URL_HOME_SERVLET);
        }
    }
}
