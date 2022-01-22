package org.anshin.filters;

import org.anshin.entities.User;
import org.anshin.enums.Role;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = "UsersServlet")
public class UsersServletFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute(User.SESSION_ATTRIBUTE) != null) {
            User user = (User) session.getAttribute(User.SESSION_ATTRIBUTE);
            if (user.getRole().equals(Role.ADMIN)) {
                chain.doFilter(req, res);
            } else {
                res.sendRedirect("/");
            }
        } else {
            res.sendRedirect("/auth");
        }

    }
}
