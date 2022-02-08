package org.anshin.web.servlet.admin;

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

/**
 * how to work with url?
 */
@WebServlet(urlPatterns = URL_DELETE_USER_SERVLET, name = NAME_DELETE_USER_SERVLET)
public class DeleteUserServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserServiceImpl) config.getServletContext().getAttribute(ATTRIBUTE_USER_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter(PARAMETER_USER_ID) != null) {
            Long id = Long.parseLong(req.getParameter(PARAMETER_USER_ID));
            userService.delete(id);
        }
        resp.sendRedirect(URL_ALL_USERS_SERVLET);
    }
}
