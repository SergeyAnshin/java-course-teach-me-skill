package org.anshin.web.filter;

import org.anshin.entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.anshin.web.servlet.ServletConstants.*;

@WebFilter(servletNames = {NAME_CALCULATOR_SERVLET, NAME_CALCULATION_HISTORY_SERVLET, NAME_LOGOUT_SERVLET,
        NAME_USER_SETTINGS, NAME_DELETE_CALCULATION_RESULT_SERVLET})
public class AuthenticatedUsersFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute(ATTRIBUTE_SESSION_AUTH_USER) != null) {
            User user = (User) session.getAttribute(ATTRIBUTE_SESSION_AUTH_USER);
            if (user.isAuthorized()) {
                chain.doFilter(req, res);
            } else {
                res.sendRedirect(req.getContextPath() + URL_AUTHENTICATION_SERVLET);
            }
        } else {
            res.sendRedirect(req.getContextPath() + URL_AUTHENTICATION_SERVLET);
        }
    }
}
